import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        // Richiedo i vari dati per controllare se idoneo
        System.out.println("Benvenuto! Vediamo se puoi accedere al corso avanzato.");

        System.out.print("Numero di certificazioni ottenute: ");
        int certificati = input.nextInt();

        System.out.print("Anni di esperienza in programmazione: ");
        int esperienza = input.nextInt();

        System.out.print("Età: ");
        int anni = input.nextInt();

        boolean idoneo = false;          // Controllo se è idoneo


        // Se maggiorenne e con 2 anni di esperienza allora idoneo true
        if (anni > 18 && esperienza >= 2) {
            System.out.println("Accesso approvato: hai età ed esperienza!");
            idoneo = true;

            // se ha piu di un certificato e ha un eta compre tra 16 e 18 anni iclusi allora idoneo
        } else if (certificati >= 1 && anni >= 16 && anni <= 18) {
            System.out.println("Accesso approvato: giovane con certificazione!");
            idoneo = true;
        }

        // Variabile in comune per gli anni e l esperienza su cui poi vado a calcolare la radice quadrata
        double somma = anni + esperienza;
        double radice = Math.sqrt(somma);           // Calcolo la radice quadrata
        System.out.println("La radice quadrata tra anni ed esperienza è: "+ radice);

        // Controllo se idoneo e stampo idoneo 
        if (idoneo) {
            System.out.println(" Idoneo al corso!");
            
            // se non idoneo stampo non idoneo
        } else {                            
            System.out.println(" Non idoneo al corso.");
        }

        input.close();
    }
}
