import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

// interfaccia per ricevere aggiornamenti
interface OsservatorePagamento {
    void aggiorna(String statoPagamento, double importo);
}

// Classe singleton
class GestoreEventiPagamento {

    private static GestoreEventiPagamento istanzaUnica; // Unica istanza

    // Costruttore privato!
    private GestoreEventiPagamento() {

    }

    // Metodo per creare l istanza
    public static GestoreEventiPagamento getIstanza() {
        if (istanzaUnica == null) {
            istanzaUnica = new GestoreEventiPagamento();
        }
        return istanzaUnica;
    }

    // Un metodo semplice per comunicare cosa succede nel sistema.
    public void messaggio(String messaggio) {
        System.out.println(messaggio);
    }
}


// Classe osservatore concreta che simula l'aggiornamento del magazzino con invio o non invio del prodotto
class MagazzinoObserver implements OsservatorePagamento {
    @Override
    public void aggiorna(String statoPagamento, double importo) {    // Lo stato del pagamento ci serve per decidere quale messaggio inviare
        if (statoPagamento.equals("SUCCESSO")) {
            System.out.println("Pagamento di " + importo + " Euro riuscito! Preparo l'ordine per la spedizione. (Osservatore per invio del prodotto)");
        } else {
            System.out.println("Pagamento di " + importo + " Euro fallito! Ordine annullato.");
        }
    }
}

// Classe osservatore concreta per email di conferma
class OsserverEmail implements OsservatorePagamento {
    @Override
    public void aggiorna(String statoPagamento, double importo) {
        if (statoPagamento.equals("SUCCESSO")) {       // Se pagamento andato a buon fine invio email di conferma
            System.out.println("Pagamento di " + importo + " Euro riuscito! Invio email di conferma ordine al cliente. (Osservatore per invio dell email di conferma)");
        } else {
            System.out.println("Pagamento di " + importo + " Euro fallito!. Invio email di cancellazione ordine al cliente.");
        }
    }
}


// Interfaccia factory per capire che tipo di pagamento si vuole effettuare
interface MetodoPagamento {
    void paga(double importo);
}


// Queste sono le classi vere e proprie per i diversi tipi di pagamento.
class PagamentoCarta implements MetodoPagamento {
    @Override
    public void paga(double importo) {
        System.out.println("Pagamento con Carta di Credito");
        System.out.println("Sto pagando: " + importo + " Euro con la carta.");
        System.out.println("Pagamento con carta completato!");
    }
}

class PagamentoPayPal implements MetodoPagamento {
    @Override
    public void paga(double importo) {
        System.out.println("Pagamento con PayPal");
        System.out.println("Sto pagando: " + importo + " Euro con paypal.");
        System.out.println("Pagamento con PayPal completato!");
    }
}



// Classe factory per decidere quale oggetto istanziare in base al tipo di pagamento che si vuole fare
class GestorePagamentiSemplice {

    // costanti
    public static final String TIPO_CARTA = "carta";
    public static final String TIPO_PAYPAL = "paypal";
  
    // con questo metodo decidiamo quale oggetto creare in base al tipo
    public static MetodoPagamento creaMetodoPagamento(String tipo) {
        if (tipo.equalsIgnoreCase(TIPO_CARTA)) {
            return new PagamentoCarta();
        } else if (tipo.equalsIgnoreCase(TIPO_PAYPAL)) {
            return new PagamentoPayPal();
        } else {
            // Se il tipo non è riconosciuto, stampo un errore e restituisco null.
            System.out.println("Errore: Tipo di pagamento '" + tipo + "' non riconosciuto!");
            return null;
        }
    }
}

// Classe facade dove all interno ho messo la lista di osservatori
class Facade {
    private double importoCarrello;
    // Lista degli osservatori che devono essere avvisati.
    private List<OsservatorePagamento> osservatori = new ArrayList<>();

    public Facade(double importo) {
        this.importoCarrello = importo;
        // Ogni volta che inizia un facade, il Singleton GestoreEventiPagamento lo comunica.
        GestoreEventiPagamento.getIstanza().messaggio("Nuovo checkout iniziato per " + importo + " Euro.");
    }

    // Metodo per aggiungere un osservatore alla lista.
    public void aggiungiOsservatore(OsservatorePagamento osservatore) {
        osservatori.add(osservatore);
        GestoreEventiPagamento.getIstanza().messaggio("Aggiunto osservatore: " + osservatore.getClass().getSimpleName());
    }

    // Metodo privato per avvisare tutti gli osservatori registrati.
    private void notificaOsservatori(String statoPagamento, double importo) {
        for (OsservatorePagamento obs : osservatori) {
            obs.aggiorna(statoPagamento, importo);
        }
    }

    // Metodo con cui il cliente paga prendendo come parametro il tipo di pagamento che si vuole utilizzare
    public void pagaIlMioOrdine(String metodoScelto) {
        System.out.println("\nCHECKOUT");
        System.out.println("Il tuo totale è: " + importoCarrello + " Euro.");

        // Usiamo la "fabbrica" per ottenere il metodo di pagamento corretto.
        MetodoPagamento metodo = GestorePagamentiSemplice.creaMetodoPagamento(metodoScelto);
        String statoFinalePagamento = "FALLITO"; // Partiamo dal presupposto che il pagamento fallisca.

        if (metodo != null) {
            try {
                metodo.paga(importoCarrello); // Eseguiamo il pagamento vero e proprio.
                statoFinalePagamento = "SUCCESSO"; // Se non ci sono errori, il pagamento è riuscito.
                System.out.println("Ordine completato con successo! Grazie!");
            } catch (Exception e) {
                // In caso di errori durante il pagamento.
                System.out.println("Si è verificato un errore durante il pagamento: " + e.getMessage());
                GestoreEventiPagamento.getIstanza().messaggio("Errore pagamento: " + e.getMessage());
            }
        } else {
            System.out.println("Non è stato possibile completare il pagamento. Metodo sconosciuto.");
            GestoreEventiPagamento.getIstanza().messaggio("Tentativo di pagamento con metodo sconosciuto: " + metodoScelto);
        }

        // Dopo aver tentato il pagamento, notifichiamo tutti gli osservatori.
        notificaOsservatori(statoFinalePagamento, importoCarrello);
        GestoreEventiPagamento.getIstanza().messaggio("Notificati osservatori stato pagamento impostato su: " + statoFinalePagamento);
        System.out.println("FINE CHECKOUT\n");
    }

  public void setImportoCarrello(double newImporto) {
        this.importoCarrello = newImporto;
        GestoreEventiPagamento.getIstanza().messaggio("Importo carrello aggiornato a: " + newImporto + " Euro.");
    }
    public double getImportoCarrello() {
        return this.importoCarrello;
    }
}


public class Esercizio2 {
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Singleton
        GestoreEventiPagamento notificatore = GestoreEventiPagamento.getIstanza();
        notificatore.messaggio("Sistema e-commerce avviato.");

        double prezzoDegliArticoliNelCarrello = 80.0; // Prezzo di partenza

        System.out.println("Benvenuto! Hai " + prezzoDegliArticoliNelCarrello + " Euro nel carrello e sei al checkout.");

        // Creiamo la nostra Facade per il checkout, che gestirà il pagamento.
        Facade mioCheckout = new Facade(prezzoDegliArticoliNelCarrello);

        // Osservatori
        MagazzinoObserver magazzino = new MagazzinoObserver();
        OsserverEmail emailer = new OsserverEmail();

        // Aggiungo gli osservatori nel checkout
        mioCheckout.aggiungiOsservatore(magazzino);
        mioCheckout.aggiungiOsservatore(emailer);

        

        // Loop per il menu
        String sceltaUtente;
        do {
            System.out.println("\nMenu Principale");
            System.out.println("1. Inserisci denaro nel portafoglio ");
            System.out.println("2. Paga con Carta di Credito");
            System.out.println("3. Paga con PayPal");
            System.out.println("4. Stampa contenuto del carrello e costo attuale");
            System.out.println("0. Esci dal programma");
            System.out.print("Scegli un'opzione: ");

            sceltaUtente = scanner.nextLine();

            switch (sceltaUtente) {
                case "1":
                    System.out.print("Quanto denaro vuoi aggiungere al carrello?: ");
                    try {
                        double aggiunta = Double.parseDouble(scanner.nextLine());  // Trasmormo la stringa in double
                        prezzoDegliArticoliNelCarrello += aggiunta;                // Aggiorno il prezzo degli articoli 
                        mioCheckout.setImportoCarrello(prezzoDegliArticoliNelCarrello); // Aggiorno il prezzo totale nel carrello
                        System.out.println("Denaro aggiunto. Nuovo importo nel carrello: " + prezzoDegliArticoliNelCarrello + " Euro.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input non valido. Inserisci un numero per l'importo.");
                    }
                    break;
                case "2":
                    mioCheckout.pagaIlMioOrdine(GestorePagamentiSemplice.TIPO_CARTA);
                    break;
                case "3":
                    mioCheckout.pagaIlMioOrdine(GestorePagamentiSemplice.TIPO_PAYPAL);
                    break;
                case "4":
                    System.out.println("\nContenuto Carrello");
                    System.out.println("Costo attuale del carrello: " + mioCheckout.getImportoCarrello() + " Euro.");
                    System.out.println("--------------------------");
                    break;
                case "0":
                    System.out.println("Uscita dal programma. Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida. Per favore, inserisci un numero tra 0 e 4.");
                    break;
            }

        } while (!sceltaUtente.equals("0")); // Continua finché l'utente non sceglie di uscire

        scanner.close();
        notificatore.messaggio("Sistema e-commerce terminato.");
    }
}