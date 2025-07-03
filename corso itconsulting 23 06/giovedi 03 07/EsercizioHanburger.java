import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioHanburger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;                             // Variabile per continuare il ciclo del menu
        ArrayList<Hamburger> ordine = new ArrayList<>();     // Lista degli ordini
        double totale = 0;                                   // Totale da pagare

        System.out.println("Benvenuto alla Burgeria!");

        // Menu della burgeria
        while (continua) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cheeseburger - €5.50");
            System.out.println("2. VegBurger - €5.00");
            System.out.println("3. DoubleBacon - €6.50");
            System.out.println("4. Visualizza ordine");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:                                                             // Caso 1 aggiungi un Cheeseburger
                    Hamburger cheese = new Cheeseburger("Cheeseburger");
                    ordine.add(cheese);                                             // Aggiungo il panino alla lista degli ordini
                    totale += 5.50;                                                 // Aggiungo il prezzo del panino al totale
                    System.out.println(cheese.prepara());                           // Stampo direttamente il metodo prepara che mi ritorna la stringa con la stampa degli ingredienti
                    break;
                case 2:                                                             // Caso 2 aggiungi un VegBurger 
                    Hamburger veg = new VegBurger("VegBurger");
                    ordine.add(veg);
                    totale += 5.00;
                    System.out.println(veg.prepara());                              
                    break;
                case 3:                                                             // Caso 3 aggiungi un DoubleBacon                      
                    Hamburger bacon = new DoubleBacon("DoubleBacon");
                    ordine.add(bacon);
                    totale += 6.50;
                    System.out.println(bacon.prepara());
                    break;
                case 4:                                                             // Caso 4 stampa ordine
                    System.out.println("\n--- Ordine attuale ---");
                    for (Hamburger h : ordine) {
                        System.out.println("- " + h.getNome());
                    }
                    System.out.println("Totale: " + totale + "Euro");
                    break;
                case 0:                                                              // Esci
                    System.out.println("\nGrazie per aver ordinato!");
                    System.out.println("Hai ordinato:\n");

                    for (Hamburger h : ordine) {                                     // Stampo nome e ingredienti di ogni panini ordinato
                        System.out.println(h.getNome() + " - Ingredienti: " + h.prepara());
                    }

                    System.out.println("\nTotale da pagare: "+ totale+ "Euro");     // Stampo il totale da pagare
                    continua = false;                                               // Esco dal ciclo
                    break;
                default:
                    System.out.println("Scelta non valida.");                     // Caso di default
            }
        }

        scanner.close();
    }
}

// Classe base
class Hamburger {
    private String nome;

    public Hamburger(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Metodo per preparare un panino
    public String prepara() {
        return "Metodo per preparare un panino!";
    }
}

// Sottoclassi specifiche
class Cheeseburger extends Hamburger {

    public Cheeseburger(String nome) {
        super(nome);
    }

    // Override per il cheeseburger
    @Override
    public String prepara() {
        return "Cheeseburger - pane, carne, formaggio e ketchup";
    }
}

class VegBurger extends Hamburger {

    public VegBurger(String nome) {
        super(nome);
    }

    // Override per il VegBurger
    @Override
    public String prepara() {
        return "VegBurger - pane integrale, burger vegetale, insalata e pomodoro";
    }
}

class DoubleBacon extends Hamburger {

    public DoubleBacon(String nome) {
        super(nome);
    }

    // Override per doubleburger
    @Override
    public String prepara() {
        return "DoubleBacon - pane, doppia carne, bacon, cheddar, maionese";
    }
}