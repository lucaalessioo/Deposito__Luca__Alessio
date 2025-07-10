public class Application {

    public static void main(String[] args) {
        System.out.println(" CREAZIONE ORDINE HAMBURGER");
        System.out.println("-----------------------------");

        // Oggetto del tipi Hamburger con richiamo del metodo statico getistance dalla classe BaseBurger
        Hamburger panino = BaseBurger.getInstance(); 
        Observer logger = new ObserverConcreto();      // Oggetto dell observer concreto per utilizzare l override del metodo aggiornamento

        FormaggioDecorator conFormaggio = new FormaggioDecorator(panino);  // Ogetto aggiunta formaggio passandogli il panino come parametro
        conFormaggio.aggiungiObserver(logger);  // Aggiungo l observer alla lista di observer
        // Richiamo il metodo per notificare, che al suo interno ha il metodo aggiornamento dell observer concreto
        conFormaggio.notificaObservers("Formaggio aggiunto all'hamburger.");

        BaconDecorator conBacon = new BaconDecorator(conFormaggio); // Creo l oggetto per aggiungere il bacon 
        conBacon.aggiungiObserver(logger);  // Aggiungo il nuovo observer alla lista
        conBacon.notificaObservers("Bacon aggiunto all'hamburger."); // Notifico i cambiamenti come prima

        System.out.println("-----------------------------");
        System.out.println(" SCONTRINO FINALE:");
        System.out.println("Descrizione: " + conBacon.getDescrizione());
        System.out.println("Prezzo totale: " + conBacon.getPrezzo());

        panino = null;

        System.gc();
    }
}