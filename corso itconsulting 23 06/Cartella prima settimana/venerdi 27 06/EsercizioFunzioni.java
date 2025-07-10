import java.util.Scanner;

public class EsercizioFunzioni {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continua;

        // ciclo do per il menu 
        do {
            System.out.println("\nBenvenuto!");
            System.out.println("Scegli cosa vuoi fare:");
            System.out.println("1. Calcolare il fattoriale");
            System.out.println("2. Calcolare una potenza");

            int scelta = scanner.nextInt();

            // scelta 1 fattoriale
            if (scelta == 1) {
                System.out.print("Inserisci un numero intero: ");
                int numero = scanner.nextInt();

                // controllo se l inserimento è un numero maggiore di 0 altrimenti stampo errore
                if (numero < 0) {
                    System.out.println("Il fattoriale non è definito per numeri negativi.");

                    // stampo del fattoriale
                } else {
                    System.out.println("Il fattoriale di " + numero + " è: " + fattoriale(numero));
                }

                // scelta 2 calcolo la potenza 
            } else if (scelta == 2) {
                System.out.print("Inserisci la base : ");
                int base = scanner.nextInt();
                System.out.print("Inserisci l'esponente: ");
                int esponente = scanner.nextInt();

                // controllo sul numero dell esponente che non puo essere negativo
                if (esponente < 0) {
                    System.out.println("L'esponente deve essere maggiore o uguale a zero.");
                    // richiamo il metodo potenza scritto sotto fuori dal main 
                } else {
                    System.out.println(base + " elevato a " + esponente + " è: " + potenza(base, esponente));
                }
            } else {
                System.out.println("Scelta non valida.");
            }

            // chiedo se si vuole continuare 
            System.out.print("\nVuoi fare un altro calcolo? (sì/no): ");
            scanner.nextLine();
            continua = scanner.nextLine();

        } while (continua.equalsIgnoreCase("sì") || continua.equalsIgnoreCase("si"));   // controllo per l uscita

        System.out.println("Grazie per aver usato il programma!");
        scanner.close();
    }

    // funzione per il fattoriale 
    public static int fattoriale(int n) {
        int risultato = 1;
        for (int i = 1; i <= n; i++) {
            risultato *= i;
        }
        return risultato;
    }

    //funzione per il calcolo della potenza
    public static int potenza(int base, int esponente) {
        int risultato = 1;
        for (int i = 0; i < esponente; i++) {
            risultato *= base;
        }
        return risultato;
    }
    
}
