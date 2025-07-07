public class SingletonTest {
  public static void main(String[] args) {
    // Ottieni due istanze della classe Singleton
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();

    // Chiama un metodo su una delle istanze
    s1.DoSomething();

    // Verifica se entrambe le istanze sono uguali (devono esserlo!)
    if (s1 == s2) {
      System.out.println("Entrambe le istanze sono uguali! Singleton funzionante.");
    } else {
      System.out.println("Le istanze sono diverse! Singleton NON funzionante.");
    }
  }
}

class Singleton 
{
  // Istanza privata statica della classe Singleton
  private static Singleton instance;

  // Costruttore privato per impedire l'istanziazione diretta
  private Singleton() {}
  
  // Metodo pubblico statico per ottenere l'unica istanza della classe
  public static Singleton getInstance() 
  {
    // Se l'istanza non esiste, viene creata
    if (instance == null) 
    {
      instance = new Singleton();
    }
    // Restituisce l'istanza esistente o appena creata
    return instance;
  }

  // Metodo di esempio che può essere chiamato sull'istanza Singleton
  public void DoSomething()
  {
    System.out.println("Singleton: DoSomething() called");
  }
}

