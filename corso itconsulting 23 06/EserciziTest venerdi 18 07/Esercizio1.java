import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// CLASSE BASE: VEICOLO
abstract class Veicolo { // La classe base astratta

    // Attributi privati per l'incapsulamento
    private String marca;
    private int anno;

    // Costruttore
    public Veicolo(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }

    // Getter e Setter per l'incapsulamento
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    // Metodo dettagli() che verrà sovrascritto 
    public String dettagli() {
        return "Marca: " + marca + ", Anno: " + anno;
    }

    // Metodo astratto 
    public abstract String tipoVeicolo();
}

// SOTTOCLASSE AUTO 
class Auto extends Veicolo {
    private int numeroPorte; // Attributo specifico per Auto

    public Auto(String marca, int anno, int numeroPorte) {
        super(marca, anno); // Chiama il costruttore della superclasse
        this.numeroPorte = numeroPorte;
    }

    // Getter e Setter specifici
    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    // Override del metodo dettagli
    @Override
    public String dettagli() {
        return super.dettagli() + ", Tipo: Auto, Porte: " + numeroPorte;
    }

    // Implementazione del metodo astratte della classe Veicolo
    @Override
    public String tipoVeicolo() {
        return "Auto";
    }
}

// SOTTOCLASSE MOTO 
class Moto extends Veicolo {
    private String tipoManubrio;                                  // Attributo specifico per Moto

    public Moto(String marca, int anno, String tipoManubrio) {
        super(marca, anno);                                       // Chiama il costruttore della superclasse
        this.tipoManubrio = tipoManubrio;
    }

                                                                   // Getter e Setter specifici
    public String getTipoManubrio() {
        return tipoManubrio;
    }

    public void setTipoManubrio(String tipoManubrio) {
        this.tipoManubrio = tipoManubrio;
    }

    // Override del metodo dettagli
    @Override
    public String dettagli() {
        return super.dettagli() + ", Tipo: Moto, Manubrio: " + tipoManubrio;
    }

    // Override metodo astratto
    @Override
    public String tipoVeicolo() {
        return "Moto";
    }
}

// Main
public class Esercizio1 {
    private static ArrayList<Veicolo> listaVeicoli = new ArrayList<>();     // ArrayList di veicoli
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int scelta;

        do {
            stampaMenu();                               // Apertura del menu tramite il metodo statiche del menu scritto sotto
            
                scelta = scanner.nextInt();             // Prendo l input dell utente relativa alla scelta
                scanner.nextLine(); 

                switch (scelta) {
                    case 1:
                        aggiungiVeicolo();              // Metodo per aggiungere un veicolo
                        break;
                    case 2:
                        visualizzaVeicoli();            // Metodo per visualizzare i veicoli
                        break;
                    case 3:
                        modificaVeicolo();              // Metodo per modificare un veicolo
                        break;
                    case 4:
                        eliminaVeicolo();               // Metodo per eliminare un veicolo
                        break;
                    case 0:
                        System.out.println("Uscita dal programma. Arrivederci!");   // Esci
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");          // Errore di inserimento
                }
       
        } while (scelta != 0);

        scanner.close();
    }

    // Metodo statico per aprire il menu
    private static void stampaMenu() {
        System.out.println("Gestione Veicoli");
        System.out.println("1. Aggiungi Veicolo");
        System.out.println("2. Visualizza Tutti i Veicoli");
        System.out.println("3. Modifica Dettagli Veicolo");
        System.out.println("4. Elimina Veicolo");
        System.out.println("0. Esci");
        System.out.print("Cosa vuoi fare ? ");
    }

    // Metodo statico per aggiungere un veicolo 
    private static void aggiungiVeicolo() {
        System.out.println("\nAggiungi Nuovo Veicolo");
        System.out.print("Tipo di veicolo (Auto/Moto): ");
        String tipo = scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Anno: ");
        int anno = scanner.nextInt();
        scanner.nextLine();

        // Se inserito Auto chiedi numero porte 
        if (tipo.equalsIgnoreCase("Auto")) {
            System.out.print("Numero Porte: ");
            int porte = scanner.nextInt();
            scanner.nextLine();
            listaVeicoli.add(new Auto(marca, anno, porte));
            System.out.println("Auto aggiunta con successo!");

        } else if (tipo.equalsIgnoreCase("Moto")) {
            System.out.print("Tipo Manubrio: ");
            String manubrio = scanner.nextLine();
            listaVeicoli.add(new Moto(marca, anno, manubrio));
            System.out.println("Moto aggiunta con successo!");
        } else {
            System.out.println("Tipo di veicolo non riconosciuto. Riprova.");
        }
    }

    private static void visualizzaVeicoli() {
        System.out.println("\nTutti i Veicoli");
        if (listaVeicoli.isEmpty()) {
            System.out.println("Nessun veicolo presente nella lista.");
            return;
        }
        
        for (int i = 0; i < listaVeicoli.size(); i++) {
            Veicolo v = listaVeicoli.get(i);
            System.out.println( v.dettagli());
        }
    }

    private static void modificaVeicolo() {
        System.out.println("\nModifica Dettagli Veicolo");
        if (listaVeicoli.isEmpty()) {
            System.out.println("Nessun veicolo da modificare.");
            return;
        }

        visualizzaVeicoli();
        System.out.print("Inserisci il numero del veicolo da modificare: ");
        int indice = scanner.nextInt() - 1;

        if (indice >= 0 && indice < listaVeicoli.size()) {
            Veicolo veicoloDaModificare = listaVeicoli.get(indice);
            System.out.println("Modifica per: " + veicoloDaModificare.dettagli());

            System.out.print("Nuova Marca (Lascia vuoto per non modificare): ");
            String nuovaMarca = scanner.nextLine();
            if (!nuovaMarca.isEmpty()) {
                veicoloDaModificare.setMarca(nuovaMarca);
            }

            System.out.print("Nuovo Anno (0 per non modificare): ");
            int nuovoAnno = scanner.nextInt();
            if (nuovoAnno != 0) {
                veicoloDaModificare.setAnno(nuovoAnno);
            }

            
            if (veicoloDaModificare instanceof Auto) {
                Auto auto = (Auto) veicoloDaModificare;
                System.out.print("Nuovo Numero Porte (0 per non modificare): ");
                int nuovePorte = scanner.nextInt();
                if (nuovePorte != 0) {
                    auto.setNumeroPorte(nuovePorte);
                }
            } else if (veicoloDaModificare instanceof Moto) {
                Moto moto = (Moto) veicoloDaModificare;
                System.out.print("Nuovo Tipo Manubrio (Lascia vuoto per non modificare): ");
                String nuovoManubrio = scanner.nextLine();
                if (!nuovoManubrio.isEmpty()) {
                    moto.setTipoManubrio(nuovoManubrio);
                }
            }
            System.out.println("Veicolo modificato con successo!");
        } else {
            System.out.println("Numero veicolo non valido.");
        }
    }

    private static void eliminaVeicolo() {
        System.out.println("\nElimina Veicolo");
        if (listaVeicoli.isEmpty()) {
            System.out.println("Nessun veicolo da eliminare.");
            return;
        }

        visualizzaVeicoli();
        System.out.print("Inserisci il numero del veicolo da eliminare: ");
        int indice = scanner.nextInt() - 1;

        if (indice >= 0 && indice < listaVeicoli.size()) {
            Veicolo rimosso = listaVeicoli.remove(indice);
            System.out.println("Veicolo " + rimosso.getMarca() + " rimosso con successo!");
        } else {
            System.out.println("Numero veicolo non valido.");
        }
    }
  
}