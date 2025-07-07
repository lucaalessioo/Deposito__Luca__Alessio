public class LoggerTest {
  public static void main(String[] args) {
    // Ottieni due istanze del Logger
    Logger logger1 = Logger.getInstance();
    Logger logger2 = Logger.getInstance();

    // Usa il logger per stampare messaggi
    logger1.log("Questo è il primo messaggio di log.");
    logger2.log("Questo è il secondo messaggio di log.");

    // Verifica se le due istanze sono uguali
    if (logger1 == logger2) {
      System.out.println("Logger è un singleton: stessa istanza!");
    } else {
      System.out.println("Logger NON è un singleton: istanze diverse!");
    }
  }
}

// Definizione della classe Logger come singleton
class Logger 
{
  // Istanza privata statica della classe Logger
  private static Logger instance;

  // Costruttore privato per impedire l'istanziazione diretta
  private Logger() {}

  // Metodo pubblico statico per ottenere l'unica istanza di Logger
  public static Logger getInstance() 
  {
    // Se l'istanza non esiste, viene creata
    if (instance == null) 
    {
      instance = new Logger();
    }
    // Restituisce l'istanza esistente
    return instance;
  }

  // Metodo per stampare un messaggio di log
  public void log(String msg) 
  {
    System.out.println("[LOG] " + msg);
  }
}
