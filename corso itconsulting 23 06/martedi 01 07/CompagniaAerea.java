import java.util.ArrayList;
import java.util.Scanner;

// MAIN

public class CompagniaAerea {
    public static void main(String[] args) {
       
        Scanner interi = new Scanner(System.in);
        Scanner stringhe = new Scanner(System.in);
        Compagnia compagnia = new Compagnia("alitalia");                                 // nome compagnia hardcodata
        GestoreAerei gestoreAerei = new GestoreAerei(compagnia, interi, stringhe);            //  ogetto utilizzato per richiamare il menu per gli aerei
        GestorePiloti gestorePiloti = new GestorePiloti(compagnia, interi, stringhe);         // oggetto utilizzato per richiamare il menu piloti

        int scelta;
        // Menu principale di scelta
        do {
            System.out.println("\n--- MENU PRINCIPALE ---");
            System.out.println("1. Gestione Aerei");
            System.out.println("2. Gestione Piloti");
            System.out.println("3. Visualizza tutte le info");
            System.out.println("4. Esci");
            System.out.print("Scegli: ");

         
            scelta = interi.nextInt();
            

            switch (scelta) {
                // Apertura menu degli aerei
                case 1:
                    gestoreAerei.menuAerei();
                    break;
                // Apertura menu piloti
                case 2:
                    gestorePiloti.menuPiloti();
                    break;
                // Visualizza le informazioni della compagnia quindi aerei e piloti
                case 3:
                    compagnia.stampaInformazioni();
                    break;
                // Esci
                case 4:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 4);


    }
}

// Classe pilota 

// Variabili d istanza
// costruttore 
// getters and setters con controllo sul setOreVolo per vedere se inserito un valore valido
// metodo per stampare i dettagli del pilota

class Pilota {
    //variabili d istanza
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;
    // costruttore
    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        this.oreVolo = oreVolo;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }
    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }
    public int getOreVolo() {
        return oreVolo;
    }
    public void setOreVolo(int oreVolo) {                   // Controllo sull inserimento
        if(oreVolo > 0)
        this.oreVolo = oreVolo;
        else
        System.out.println("Le ore del volo devono essere positive.");
    }

    // metodo per stampare i dettagli
    public void stampaDettagli() {
        System.out.println("Pilota: Nome = " + nome + ", Brevetto = " + numeroBrevetto + ", Ore di volo = " + oreVolo);
    }
}

// Classe Aereo

// Variabili d istanza
// costruttore 
// getters and setters con controllo sul numero posti 
// metodo per stampare i dettagli dell aereo

class Aereo {
    // variabili d istanza
    private String modello;
    private int numPosti;
    private String codice;
    // costruttore
    public Aereo(String modello, int numPosti, String codice) {
        this.modello = modello;
        this.numPosti = numPosti;
        this.codice = codice;
    }
    // Getters adn Setters
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public int getNumPosti() {
        return numPosti;
    }
    public void setNumPosti(int numPosti) {                                             // Setter sul numero posti con controllo inserimento
        if(numPosti > 0)
        this.numPosti = numPosti;
        else System.out.println("Il numero inserito non deve essere maggiore di 0");
    }
    public String getCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }

        // metodo di stampa dettagli
        public void stampaDettagli() {
        System.out.println("Aereo: Modello = " + modello + ", Posti = " + numPosti + ", Codice = " + codice);
    }
}

// Classe CompagniaAerea

// Metodo per aggiungere un aereo
// Metodo per aggiungere un pilota
// Getters and Setters
// Metodo per stampare le informazioni

class Compagnia {
    private String nome;
    private ArrayList<Aereo> flotta = new ArrayList<>();
    private ArrayList<Pilota> piloti = new ArrayList<>();

    public Compagnia(String nome) {
        this.nome = nome;
    }

    // Metodo per aggiungere un aereo
    public void aggiungiAereo(Aereo aereo) {
    // ciclo l arraylist della flotta
        for (Aereo a : flotta) {
            if (a.getCodice().equalsIgnoreCase(aereo.getCodice())) {                   //confronto il codice dell aereo se presente stampo errore e interrompo
                System.out.println("Errore: codice aereo già presente.");
                return;
            }
        }
        flotta.add(aereo);                                                             // altrimenti aggiungo l aereo
        System.out.println("Aereo aggiunto.");
    }

    // Metodo per aggiungere un aereo alla lista
    public void aggiungiPilota(Pilota pilota) {
    // ciclo la lista di piloti
        for (Pilota p : piloti) {   
            if (p.getNumeroBrevetto().equalsIgnoreCase(pilota.getNumeroBrevetto())) {   // confronto il numero di brevetto se ne trovo anche sono uno interrompo e stampo errore
                System.out.println("Errore: brevetto pilota già presente.");
                return;
            }
        }
        piloti.add(pilota);                                                             // aggiungo l aereo
        System.out.println("Pilota aggiunto.");
    }

    //getter per vedere la flotta
    public ArrayList<Aereo> getFlotta() {
        return new ArrayList<>(flotta);
    }

    // getter per vedere la lista dei piloti
    public ArrayList<Pilota> getPiloti() {
        return new ArrayList<>(piloti);
    }

    // Metodo per stampare tutte le info della compagnia
    public void stampaInformazioni() {
        System.out.println("\nNome della Compagnia Aerea: " + nome );

        System.out.println("\nFlotta Aerei:");
        if (flotta.isEmpty()) {
            System.out.println("Nessun aereo.");
        } else {
            for (Aereo a : flotta)  {
            a.stampaDettagli();                     // richiamo il metodo stampa dettagli della classe aereo
            }
        }

        System.out.println("\nPiloti:");
        if (piloti.isEmpty()) {
            System.out.println("Nessun pilota.");
        } else {
            for (Pilota p : piloti) { 
            p.stampaDettagli();                     // richiamo il metodo stampadettagli dei piloti
            }
        }
    }
}

// Gestore Piloti con menu dedicato @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

// Metodo per il menu per i piloti
// Metodo per aggiungere un pilota
// Metodo per mostrare i piloti presenti

class GestorePiloti {
    private Compagnia compagnia;         // Ogetto compagnia da passare al menu
    private Scanner interi = new Scanner(System.in);    //scanner interi
    private Scanner stringhe = new Scanner(System.in);  // scanner stringhe

    // costruttore
    public GestorePiloti(Compagnia compagnia, Scanner interi, Scanner stringhe) {
        this.compagnia = compagnia;
        this.interi = interi;
        this.stringhe = stringhe;
    }

    // Metodo del menu per i piloti
    public void menuPiloti() {
        int scelta;
        do {
            System.out.println("\n--- Benvenuto nel menu dei piloti---");
            System.out.println("1. Aggiungi pilota");
            System.out.println("2. Visualizza tutti i piloti");
            System.out.println("3. Torna al menu principale");
            System.out.print("Scegli: ");

           
            scelta = interi.nextInt();
           

            switch (scelta) {
                // Aggiunta di un pilota
                case 1:
                    aggiungiPilota();
                    break;
                case 2:
                // Mostra i piloti presenti
                    mostraPiloti();
                    break;
                // Torna al menu principale
                case 3:
                    System.out.println("Torno al menu principale.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 3);
    }

    // Metodo per aggiungere un pilota
    private void aggiungiPilota() {
        System.out.print("Nome pilota: ");
        String nome = stringhe.nextLine();

        System.out.print("Numero brevetto: ");
        String brevetto = stringhe.nextLine();

        System.out.print("Ore di volo: ");
        int ore = interi.nextInt();

        Pilota pilota = new Pilota(nome, brevetto, ore);
        compagnia.aggiungiPilota(pilota);                  // aggiungo l oggetto completo con il metodo aggiungiPilota
    }

    // Metodo privato che mostra i piloti
    private void mostraPiloti() {
        if (compagnia.getPiloti().isEmpty()) {
            System.out.println("Nessun pilota disponibile.");
            return;
        }
        for (Pilota p : compagnia.getPiloti()) {
            p.stampaDettagli();                             // richiamo il metodo per stampare i dettagli del pilota
        }
    }

}


// Gestore Aerei con menu dedicato @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

// Metodo per il menu per aerei
// Metodo per aggiungere un aereo
// Metodo per mostrare gli aerei presenti

class GestoreAerei {
    // Metodi d istanza
    private Compagnia compagnia;
    private Scanner interi;
    private Scanner stringhe;

    // costruttore
    public GestoreAerei(Compagnia compagnia, Scanner interi , Scanner stringhe) {
        this.compagnia = compagnia;
        this.interi = interi;
        this.stringhe = stringhe;
    }

    public void menuAerei() {
        int scelta;
        do {
            System.out.println("\n--- Benvenuto nel menu per gli aerei ---");
            System.out.println("1. Aggiungi aereo");
            System.out.println("2. Visualizza tutti gli aerei");
            System.out.println("3. Torna al menu principale");
            System.out.print("Scegli: ");

            
            scelta = interi.nextInt();
          

            switch (scelta) {
                // Aggiungi un aereo
                case 1:
                    aggiungiAereo();
                    break;
                // Stampa flotta
                case 2:
                    mostraAerei();
                    break;
                // Menu principale
                case 3:
                    System.out.println("Torno al menu principale.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 3);
    }
    
     // Metodo per aggiungere un aereo
     private void aggiungiAereo() {
        System.out.print("Modello: ");
        String modello = stringhe.nextLine();

        System.out.print("Numero posti: ");
        int posti = interi.nextInt();

        System.out.print("Codice aereo: ");
        String codice = stringhe.nextLine();

        Aereo aereo = new Aereo(modello, posti, codice);
        compagnia.aggiungiAereo(aereo);                             // Aggiungo l oggetto con il metodo della compagnia
    }

    // Metodo per stampare tutti gli aerei
    private void mostraAerei() {
        if (compagnia.getFlotta().isEmpty()) {
            System.out.println("Nessun aereo disponibile.");
            return;
        }
        for (Aereo a : compagnia.getFlotta()) {
            a.stampaDettagli();
        }
}
}
