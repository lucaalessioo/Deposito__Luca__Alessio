public class SecondoEsercizio {
    public static void main(String[] args) {
        // Primo punto di accesso al DatabaseManager
        DatabaseManager db1 = DatabaseManager.getInstance();
        db1.connect();
        db1.connect();

        // Secondo punto di accesso al DatabaseManager
        DatabaseManager db2 = DatabaseManager.getInstance();
        db2.connect();

        // Accesso da un punto diverso del programma
        simulazioneAccessoEsterno();

        // Verifica se le istanze sono uguali
        System.out.println("Le istanze sono uguali? :  " + (db1 == db2));

        // Stampa il totale delle connessioni
        System.out.println("Connessioni totali: " + db1.contatore());
    
    }
    public static void simulazioneAccessoEsterno() {
        DatabaseManager db = DatabaseManager.getInstance();
        db.connect();
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