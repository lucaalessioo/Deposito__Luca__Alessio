import java.util.Scanner;

public class EsercizioFunzioni {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto nel programma per calcolare fattoriali e potenze.");
        String scelta;

        // Ciclo per il menu 
        do {
            System.out.println("\nCosa vuoi calcolare?");
            System.out.println("1. Fattoriale");
            System.out.println("2. Potenza");
            System.out.print("Inserisci 1 o 2: ");
            int opzione = scanner.nextInt();
            
            // Controllo cosa si sceglie nel menu e eseguo la rispettiva operazione
            switch (opzione) {

                // nel primo caso calcolo il fattoriale 
                case 1:
                    System.out.print("Inserisci un numero intero per calcolare il suo fattoriale: ");
                    int numero = scanner.nextInt();
                    int risultatoFattoriale = fattoriale(numero);        // Richiamo la funzione statica scritto fuori dal main

                    // controllo sul numero inserito non deve essere minore di 0 
                    if (numero < 0) {
                        System.out.println("Il fattoriale non è definito per numeri negativi.");
                    } else {
                        System.out.println("Il fattoriale di " + numero + " è: " + risultatoFattoriale);    // stampo il risultato
                    }
                    break;

                    // nel secondo caso calcolo la potenza
                case 2:
                    System.out.print("Inserisci la base (numero intero): ");     // chiedo il numero da elevare 
                    int base = scanner.nextInt();
                    System.out.print("Inserisci l'esponente (numero intero): ");    // chiedo l esponente
                    int esponente = scanner.nextInt();
                    int risultatoPotenza = potenza(base, esponente);  // richiamo il metodo statico potenza scritto fuori dal main
                    System.out.println(base + "^" + esponente + " = " + risultatoPotenza);
                    break;

                    // caso di default inseremento errato
                default:
                    System.out.println("Opzione non valida. Inserisci 1 o 2.");
            }

            System.out.print("\nVuoi fare un altro calcolo? (sì/no): ");  // chiedo se si vuole continuare a restare all interno del programma
            scelta = scanner.next();

        } while (scelta.equalsIgnoreCase("sì") || scelta.equalsIgnoreCase("si"));      // condizione di uscita 

        System.out.println("Grazie per aver usato il programma!");
        scanner.close();
    }

    // Metodo per il calcolo del fattoriale
    public static int fattoriale(int n) {
        if (n < 0) {
            return 0;
        } 
        int risultato = 1;
        for (int i = 1; i <= n; i++) {
            risultato *= i;
        }
        return risultato;
    }

    // Metodo per il calcolo della potenza
    public static int potenza(int base, int esponente) {
        int risultato = 1;
        for (int i = 0; i < Math.abs(esponente); i++) {
            risultato *= base;
        }
        // Se l'esponente è negativo restituisco 0 
        if (esponente < 0) {
            System.out.println("Nota: l'esponente è negativo, il risultato sarà approssimato a 0 (solo interi positivi).");
            return 0;
        }
        return risultato;
    }
    
}
