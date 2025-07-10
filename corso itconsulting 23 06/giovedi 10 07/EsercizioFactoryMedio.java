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

              
                System.out.println(" Notifica Osservatori per forma decorata ");
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

// Implementazione unica per forme base
class FormaBase implements IShape {
    private String tipo;

    public FormaBase(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void draw() {
        System.out.println("Sto disegnango un quadrato");
    }

}

abstract class ShapeCreator {

    public abstract IShape createShape(String tipo);

     private List<Observer> listaObserver = new ArrayList<>();

     // Metodo per aggiungere un observer alla lista
     public void addObserver(Observer observer) {
        listaObserver.add(observer);
    }

    // Metodo per rimuovere un observer alla lista
    public void removeObserver(Observer observer) {
        listaObserver.remove(observer);
    }

     // Metodo per notificare tutti gli osservatori
    protected void notifyObservers(IShape shape) {
        for (Observer observer : listaObserver) {
            observer.aggiornamento(shape);
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
            
            System.out.println("Notifica inviata: "+ nome);
    }
}

// Decoratore base
abstract class ShapeDecorator implements IShape {
    
    protected IShape decoratedShape; // soggetto da decorare

    public ShapeDecorator(IShape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}

// Decoratore concreto
class ColoreShapeDecorator extends ShapeDecorator {
    private String color;

    public ColoreShapeDecorator(IShape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Aggiungo un bordo di colore " + color + ".");
    }
}

// Observer concreto
class Notificatore implements Observer {
    private String nome;

    public Notificatore(String nome) {
        this.nome = nome;
    }

    @Override
    public void aggiornamento(IShape iShape) {
        System.out.println("Notifica inviata: " + nome);
    }
}

// Main
public class EsercizioFactoryCompatto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FormaCreator creator = new FormaCreator();
        Notificatore logger = new Notificatore("Logger principale");
        creator.addObserver(logger);

        String input;
        do {
            System.out.println("\nQuale forma vuoi creare? (circle, square) o 'fine' per uscire:");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("fine")) {
                System.out.println("Uscita dal programma.");
                break;
            }

            if (!input.equals("circle") && !input.equals("square")) {
                System.out.println("Tipo di forma non valido. Riprova.");
                continue;
            }

            IShape baseShape = creator.createShape(input);
            IShape decorated = new ColoreShapeDecorator(baseShape, "Rosso");

            System.out.println("Disegno della forma decorata:");
            decorated.draw();
            System.out.println("Disegno completato.\n");

            System.out.println("Notifica osservatori:");
            creator.notifyObservers(decorated);

        } while (true);

        scanner.close();
    }
}

