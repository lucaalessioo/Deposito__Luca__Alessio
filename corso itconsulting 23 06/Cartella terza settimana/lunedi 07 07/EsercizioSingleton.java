public class EsercizioSingleton {
    public static void main(String[] args) {
        // Creazione logger con rispettiva istanza
        Logger2 logger1 = Logger2.getIstanza();
        logger1.scriveMessaggio("Ciao");// Richiamo il metodo della classe logger
        
        Logger2 logger2 = Logger2.getIstanza(); // secondo ogetto per vedere se sono uguali 
        System.out.println("Sono uguali? " + (logger1 == logger2)); // true sono uguali
    }
}

class Logger2 {

    // Variabile statica dell ogetto Logger
    private static Logger2 istanza;

    private Logger2() {  // Costruttore privato

    }

    public static Logger2 getIstanza() {        // Metodo per prendermi l istanza se null la creo

        if(istanza == null) {
            istanza = new Logger2();
        }
        return istanza;
    }

    public void scriveMessaggio(String messaggio) {  //Metodo per scrivere un messaggio
        System.out.println("Il messaggio è: "+messaggio);
    }

}
