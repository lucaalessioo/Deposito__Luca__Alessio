import java.util.Scanner;


public class SecondoEsercizio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager db = null;     // Riferimento al Singleton
        boolean esegui = true;         // Controlla il ciclo del menu

        while (esegui) {
            // Menu principale
            System.out.println("\nMENU");
            System.out.println("1. Crea istanza Singleton");
            System.out.println("2. Usa Singleton");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt(); 

            switch (scelta) {
                // Creazione istanza
                case 1:
                    // Creazione dell'istanza Singleton se non ancora esistente
                    if (db == null) {
                        db = DatabaseManager.getInstance();
                        System.out.println("Istanza creata!");
                    } else {
                        System.out.println("Istanza già esistente.");
                    }
                    break;

                // Uso del Singleton
                case 2:
                    // Uso del Singleton: chiamata 
                    if (db != null) {
                        db.connect();               // Chiamo il metodo connect
                    } else {
                        System.out.println("Crea prima l istanza");
                    }
                    break;

                case 3:
                    // Esci
                    esegui = false;
                    System.out.println("Arrivederci.");
                    break;

                default:
                    // Input non valido
                    System.out.println("Scelta non valida.");
            }
        }

        scanner.close(); 
    }
}
    

// Singleton
class DatabaseManager {

    private static DatabaseManager istanza;       // istanza
    private int contatore = 0;                    // Contatore

    // Costruttore privato
    private DatabaseManager() {

    }

    // Getter
     public int contatore() {
        return contatore;
    }

    // Metodo per ottenere l'unica istanza della classe
    public static DatabaseManager getInstance() {
        if (istanza == null) {
            istanza = new DatabaseManager();
        }
        return istanza;
    }

    // Metodo connect
     public void connect() {

        contatore++;   // Incremento il contatore ogni volta che chiamo il metodo

        System.out.println("Ti sei connesso. Connessioni attive totali: " + contatore);
    }

}