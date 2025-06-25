import java.util.Scanner;

public class ProvaWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1; 
        // Inizializzazione della variabile di controllo
         while (i <= 5) {
          i++; // Incremento della variabile di controllo
          System.out.println(i);
         }

        int a ;
         do {
          
            System.out.println("Inserisci un numero (0 per uscire): ");
            int numero = scanner.nextInt();
            a = numero;
         }while(a != 0);
         System.out.println("Inserito 0 . Programma terminato");
        }
    }
