import java.util.ArrayList;
import java.util.List;

public class ProvaObserver {

    public static void main(String[] args) {
         // Crea il subject
        ConcreteSubject subject = new ConcreteSubject();

        // Crea e registra gli observer
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        // Cambia lo stato (notifica gli observer)
        subject.setState("Primo aggiornamento");

        // Rimuove un observer e aggiorna di nuovo
        subject.removeObserver(observer1);
        subject.setState("Secondo aggiornamento");
    }
}

// Interfaccia Observer
interface Observer {
    void update(String message);
}

// Interfaccia Subject
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// ConcreteSubject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }
}

// ConcreteObserver
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " ha ricevuto aggiornamento: " + message);
    }
}