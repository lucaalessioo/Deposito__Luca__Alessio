import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EsercizioFactoryMedio {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        ShapeCreator creator = null;

        // Inizializza gli osservatori e aggiungili al creator
        Notificatore logger = new Notificatore("Logger principale");
       

        // Loop per permettere all'utente di creare più forme
        String input;
        do {
            System.out.println("\nQuale forma vuoi creare? (circle, square) o 'fine' per uscire:");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("fine")) {
                System.out.println("Uscita dal programma.");
                break;
            }

            // Reset creator per ogni ciclo
            creator = null;

            switch (input) {
                case "circle":
                    creator = new CircleShapeCreator();
                    break;
                case "square":
                    creator = new SquareShapeCreator();
                    break;
                default:
                    System.out.println("Tipo di forma non valido. Riprova.");
                    break;
            }

            if (creator != null) {
               
                creator.addObserver(logger);
                

               
                IShape baseShape = creator.createShape(input); 

                // Applichiamo i decoratori alla forma base
                IShape decoratedShape = new ColoreShapeDecorator(baseShape, "Rosso");
               

                System.out.println("Disegno della forma decorata ");
                decoratedShape.draw(); // Questo chiamerà il draw dei decoratori e poi della forma base
                System.out.println("Disegno completato\n");

              
                System.out.println(" Notifica Osservatori : forma decorata con colore!");
                creator.notifyObservers(decoratedShape);
            }

        } while (true);

        scanner.close();
    }
}

// Interfaccia per Factory
interface IShape {
    void draw();
}

// Interfaccia per Observer
interface Observer {
    void aggiornamento(IShape iShape);
}


class Circle implements IShape {

    @Override
    public void draw() {
       System.out.println("Sto disegnando un cerchio");
    }

}

class Square implements IShape {

    @Override
    public void draw() {
        System.out.println("Sto disegnango un quadrato");
    }

}

abstract class ShapeCreator {                            // Soggetto da osservare e Factory

    public abstract IShape createShape(String tipo);

     private List<Observer> listaObserver = new ArrayList<>();

     // Metodo per aggiungere un observer alla lista
     public void addObserver(Observer observer) {       // aggiunge un osservatore
        listaObserver.add(observer);
    }

    // Metodo per rimuovere un observer alla lista
    public void removeObserver(Observer observer) {     // Rimuove un osservatore
        listaObserver.remove(observer);
    }

     // Metodo per notificare tutti gli osservatori
    protected void notifyObservers(IShape shape) {      // Notifica gli osservatori
        for (Observer observer : listaObserver) {
            observer.aggiornamento(shape);              // Metodo dell interfaccia Observer implementato per il notificatore
        }
    }
}

// Osservatore concreto: Registratore di eventi di disegno
class Notificatore implements Observer {
    private String nome;

    public Notificatore(String nome) {
        this.nome = nome;
    }

    @Override
    public void aggiornamento(IShape iShape) {
            
            System.out.println("Notifica inviata: "+ nome);         // Stampa specifica dell oggetto passatogli di tipo IShape 
    }
}

// Classe base astratta per tutti i decoratori utilizzando l interfaccia per il factory come soggetto
abstract class ShapeDecorator implements IShape {

    protected IShape decoratedShape; // soggetto da decorare

    public ShapeDecorator(IShape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    // Il metodo draw() dei decoratori chiamerà quello della forma decorata quindi del soggetto in questo caso
    @Override
    public void draw() {
        decoratedShape.draw(); // Delega il disegno alla forma sottostante
    }
}

// Decoratore concreto: aggiunge un bordo colorato
class ColoreShapeDecorator extends ShapeDecorator {
    private String color;

    public ColoreShapeDecorator(IShape decoratedShape, String color) {  // Prendo il soggetto piu il colore
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        super.draw(); // Prima disegna la forma originale
        addColoredBorder(); // Poi aggiunge il colore
    }

    private void addColoredBorder() {
        System.out.println("Aggiungo un bordo di colore " + color + ".");
    }
}

// Classi concrete per creare oggetti specifici in base alla scelta
class CircleShapeCreator extends ShapeCreator{

    @Override
    public IShape createShape(String tipo) {
        return new Circle();
    }

}

class SquareShapeCreator extends ShapeCreator {

    @Override
    public IShape createShape(String tipo) {
        return new Square();
    }

}
