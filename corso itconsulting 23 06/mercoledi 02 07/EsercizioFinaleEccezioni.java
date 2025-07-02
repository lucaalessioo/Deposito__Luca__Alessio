import java.util.InputMismatchException;
import java.util.Scanner;

public class EsercizioFinaleEccezioni {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Primo cilco per chiedere se si vuole fare la divisione se scelgo 2 esco se scelgo 1 entro nel secondo ciclo se scelgo qualsiasi altra cosa richiedo l inserimento
        while (true) {
            System.out.println("Procedere con la divisione? 1 = sì | 2 = no");

            int scelta = leggiIntero(scanner);  // Prendo l input richiamando il metodo per il controllo se è effettivamente un intero altrimenti si lancia una eccezione

            // Esci
            if (scelta == 2) {
                System.out.println("Uscita dal programma.");
                break;
                // Ripeti
            } else if (scelta != 1) {
                System.out.println("Scelta non valida. Riprova.");
                continue;
            }

            int numeratore;
            // Secondo cilco per chiedere il primo numero 
            while (true) {
                System.out.print("Inserisci il primo numero (numeratore): ");
                numeratore = leggiIntero(scanner);          // solito controllo
                try {
                    Controller.checkPositive(numeratore);     // Richiamo il metodo per il controllo se il numero è positivo
                    break; // valido, esci dal ciclo
                } catch (NumeroNegativoException e) {       // Richiamo la mia customer Exception
                    System.out.println("Eccezione: " + e.getMessage());
                    e.printStackTrace();
                    System.out.println();
                }
            }

            int denominatore;
            // In questo ciclo richiedo il secondo numero
            while (true) {
                System.out.print("Inserisci il secondo numero (denominatore): ");
                denominatore = leggiIntero(scanner);
                try {
                    Controller.checkNotZero(denominatore);      // Controllo se il numero è maggiore di 0 
                    break;
                } catch (NumeroZeroException e) {               // Catturo la mia eccezione NumeroZeroException nel caso il numero è 0
                    System.out.println("Eccezione: " + e.getMessage());
                    e.printStackTrace();
                    System.out.println();
                }
            }

            // Se arrivo qui, entrambi i numeri sono validi e faccio la divisione
            double risultato = (double) numeratore / denominatore;
            System.out.println(numeratore + " / " + denominatore + " = " + risultato);
            System.out.println(); // riga vuota per leggibilità
        }

        scanner.close();
    }

    // Metodo per leggere un intero gestendo errori di input
    private static int leggiIntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input non valido! Inserisci un numero intero.");
                scanner.nextLine(); // pulisce il buffer
            }
        }
    }
}
    

// Clasee per l eccezione personalizzata CONTROLLA SE IL NUMERO è NEGATIVO
class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Classe per l eccezione personalizzata CONTROLLA SE IL NUMERO è 0
class NumeroZeroException extends RuntimeException {
    public NumeroZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Classe Controller co i vari metodi di check
class Controller {

    // Metodo che controlla se il numero è positivo
    public static void checkPositive(int numero) throws NumeroNegativoException {
        if (numero < 0) {
            throw new NumeroNegativoException("Errore: il numero è negativo (" + numero + ")",null);
        }
    }

    // Metodo che controlla se il numero è diverso da zero
    public static void checkNotZero(int numero) {
        if (numero == 0) {
            throw new NumeroZeroException("Errore: il numero è zero", null);
        }
    }
}
