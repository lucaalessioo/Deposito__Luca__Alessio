public class EsercizioAdapterMedio {

    public static void main(String[] args) {

    //  Test del sistema Legacy diretto 
        System.out.println("--- Test del Sistema Legacy (senza Adapter) ---");
        LegacyUserSystem legacySystemDirect = new LegacyUserSystem();
        legacySystemDirect.addUser();
        legacySystemDirect.deleteUser();
        legacySystemDirect.searchUser();
        System.out.println("-----------------------------------------------\n");

        //  Test dell'Adapter (interazione con l'interfaccia Target) 
        System.out.println("Test dell'Adapter (tramite UserManagment)");
        // L'Adapter si interfaccia con il sistema legacy
        LegacyUserSystem legacySystemForAdapter = new LegacyUserSystem();
        UserManagment userManagerAdapter = new UserManagmentAdapter(legacySystemForAdapter);
        // La "nuova applicazione" (il client) usa l'interfaccia UserManagment
        userManagerAdapter.createUser();
        userManagerAdapter.deleteUser();
        userManagerAdapter.findUsere();
        System.out.println("-----------------------------------------------\n");

        //  Test del Facade (semplificazione dell'accesso)
        System.out.println("Test del Facade (accesso semplificato all'Adapter)");
        Facede userFacade = new Facede(); // Il Facade gestisce la creazione dell'Adapter e del LegacySystem
        userFacade.utilizzaFacede(); // Chiama il metodo singolo che esegue create, delete, find
        System.out.println("-----------------------------------------------\n");

        //  Test dello Strategy Pattern (comportamenti intercambiabili) 
        System.out.println("Test dello Strategy Pattern (con Facade come contesto)");

        // Inizializza il Facade che sarà il "contesto" per la strategia
        Facede strategyContextFacade = new Facede();

        System.out.println("\nEseguo la strategia: Crea Utente");
        strategyContextFacade.setStrategy(new CreaUtenteStrategy());
        strategyContextFacade.utilizzaStrategia(); // Il Facade delega alla strategia corrente

        System.out.println("\nEseguo la strategia: Cancella Utente");
        strategyContextFacade.setStrategy(new CancellaUtenteStrategy());
        strategyContextFacade.utilizzaStrategia();

        System.out.println("\nEseguo la strategia: Cerca Utente");
        strategyContextFacade.setStrategy(new CercaUtenteStrategy());
        strategyContextFacade.utilizzaStrategia();
        
        System.out.println("\nEseguo la strategia: Chiama Tutti i Metodi (come il metodo 'utilizzaFacede')");
        strategyContextFacade.setStrategy(new ChiamaTuttiMetodiStrategy());
        strategyContextFacade.utilizzaStrategia();

        System.out.println("-----------------------------------------------\n");
    }
}

// Target
interface UserManagment {

        void createUser();
        void deleteUser();
        void findUsere();
}

// Nuova interfaccia per la strategia
interface Strategy {
    void eseguiStrategia(UserManagment userManager);
}

// Classe concreta per la strategy
class CreaUtenteStrategy implements Strategy {

    @Override
    public void eseguiStrategia(UserManagment userManager) {
        userManager.createUser();
    }
}
class CancellaUtenteStrategy implements Strategy {

    @Override
    public void eseguiStrategia(UserManagment userManager) {
        userManager.deleteUser();
    }
}
class CercaUtenteStrategy implements Strategy {

    @Override
    public void eseguiStrategia(UserManagment userManager) {
        userManager.findUsere();
    }
}

class ChiamaTuttiMetodiStrategy implements Strategy {

    @Override
    public void eseguiStrategia(UserManagment userManager) {
        userManager.createUser();
        userManager.deleteUser();
        userManager.findUsere();
    }
}


// Adaptee
class LegacyUserSystem {

    public  void addUser() {
        System.out.println("Aggiungevo un utente");
    }
    public  void deleteUser() {
        System.out.println("Cancellavo un utente");
    }
    public  void searchUser() {
        System.out.println("Ricercavo un utente");
    }

}

// Adapter
class UserManagmentAdapter implements UserManagment {

   private LegacyUserSystem legacyUserSystem;

   public UserManagmentAdapter(LegacyUserSystem legacyUserSystem) {
    this.legacyUserSystem = legacyUserSystem;
   }

   @Override
   public void createUser() {
        System.out.println(" Sto creando un utente Adattato");
   }

   @Override
   public void deleteUser() {

    System.out.println(" Sto rimuovendo un utente adattato");
   }

   @Override
   public void findUsere() {
        System.out.println(" Sto cercando un utente con il nuovo metodo");
   }
}

// Classe facede per utilizzare i tre metodi con un singolo metodo nel main
class Facede {
    private UserManagment userManagment;
    private Strategy strategy;

       public Facede() {
        LegacyUserSystem legacySystem = new LegacyUserSystem();
        this.userManagment = new UserManagmentAdapter(legacySystem);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
        System.out.println("Strategia: " +strategy+ " impostata");
    }

    public void utilizzaStrategia() {
        strategy.eseguiStrategia(userManagment);
    }

    // Metodo per richiamare i 3 metodi dell adattatore
    public void utilizzaFacede() {
        System.out.print("\nCreo utente con adattatore :");
       
        userManagment.createUser(); 

        System.out.print("Cancello Utente con adattatore : ");
        userManagment.deleteUser(); 

        System.out.print("Ricerco utente con adattatore : ");
        userManagment.findUsere();  
        
    }
}