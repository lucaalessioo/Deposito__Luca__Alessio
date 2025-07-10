import java.util.ArrayList;

// Interfaccia Hamburger
interface Hamburger {
    String getDescrizione();
    double getPrezzo();
}
// Observer
interface Observer {
    void aggiornamento(String messaggio);
}

// Subject ( Observer )
interface Subject {
    void aggiungiObserver(Observer o);
    void rimuoviObserver(Observer o);
    void notificaObservers(String messaggio);
}

public class BaseBurger implements Hamburger{

    private static BaseBurger instance;  // Variabile statica di se stesso

    private BaseBurger() {               // Costruttore privato per obbligare il passaggio dal metodo getInstance

    }

    public static BaseBurger getInstance() { // Metodo per istanziare un oggetto ed uno solo
        if (instance == null) {
            instance = new BaseBurger();
        }
        return instance;
    }

    @Override
    public String getDescrizione() {
        return "Hamburger base";
    }

    @Override
    public double getPrezzo() {
        return 10.0;
    }
}

// Classe astratta Subject con lista di osservatori e instanza dell interfaccia Hamburger
abstract class HamburgerDecorator implements Hamburger, Subject {
    protected Hamburger hamburger;
    private ArrayList<Observer> observers = new ArrayList<>();

    // Per ogni Hamburger Decorator creato prendo un oggetto dell interfaccia Hamburger
    public HamburgerDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    // metodo dell interfaccia Subject
    @Override
    public void aggiungiObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void rimuoviObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notificaObservers(String messaggio) {
        for (Observer o : observers) {
            o.aggiornamento(messaggio);   // Metodo dell observer concreto per stampare il messaggio su ogni observer
        }
    }
}


// Classe concreta per notificare l aggiunta del formaggio
class FormaggioDecorator extends HamburgerDecorator {

    public FormaggioDecorator(Hamburger hamburger) {
        super(hamburger);// richiamo il costruttore di HamburgDecorator
        System.out.println(" Ingredienti: aggiunto Formaggio 0.50");
    }

    @Override
    public String getDescrizione() {
        return hamburger.getDescrizione() + ", Bacon";
    }

    @Override
    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.50;
    }
}

// Decorator per aggiungere il bacon
class BaconDecorator extends HamburgerDecorator {

    public BaconDecorator(Hamburger hamburger) {
        super(hamburger);
        System.out.println(" Ingredienti: aggiunto Bacon 0.80"); // Ad ogni oggetto Bacon Decoratore stampo aggiunto bacon
    }

    @Override
    public String getDescrizione() {
        return hamburger.getDescrizione() + ", Bacon";
    }

    @Override
    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.80;
    }
}

// Classe concreta per l Observer
class ObserverConcreto implements Observer {
    @Override
    public void aggiornamento(String messaggio) {
        System.out.println("[Observer] " + messaggio);
    }
}



