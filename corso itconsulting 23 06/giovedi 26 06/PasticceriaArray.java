import java.util.Random;
import java.util.Scanner;

public class PasticceriaArray {
    public static void main(String[] args) {
        Scanner interi = new Scanner(System.in);
        Scanner stringhe = new Scanner(System.in);
        
         Random random = new Random();
         double importoDisponibile = 10 + random.nextInt(91); // numero random tra 10 e 100         //EXTRA

        System.out.println("Saldo attuale: " + importoDisponibile);

        // Chiedo quanti dolci ordinare
        System.out.println("Quanti dolci vuoi ordinare ? : ");
        int numeroDolci = interi.nextInt();
         
        //  ciclo while .Se il numero è 0 me lo richiede non puo essere 0 senno perche sei qui ? 
          while (numeroDolci <= 0) {
            System.out.println("Errore: il numero deve essere maggiore di zero.");
            System.out.print("Quanti dolci vuoi ordinare? ");
            numeroDolci = interi.nextInt();
        }
        //DICHIARO I DUE ARRAY UNO PER  I NOMI UNO PER LE QUANTITA
        String[] nomeDolci = new String[numeroDolci];
        int[] quantitaDolci = new int[numeroDolci];

        final double prezzoDolce = 3.50; // Prezzo fisso per ogni dolce                                     //EXTRA
        double costoTotale = 0;   // Costo finale                                                           //EXTRA

        // Ciclo for per chiedere il nome del dolce che si vuole e la quantita rispettiva desiderata
         for (int i = 0; i < numeroDolci; i++) {
            System.out.print("Inserisci il nome del dolce : ");
            nomeDolci[i] = stringhe.nextLine();

            System.out.print("Inserisci la quantità per " + nomeDolci[i] + ": ");
            int quantita = interi.nextInt();

            // Controllo della quantita che sia maggiore di 0
            while (quantita <= 0) {
                System.out.println("Errore: la quantità deve essere positiva.");
                System.out.print("Inserisci la quantità per " + nomeDolci[i] + ": ");
                quantita = interi.nextInt();
            }

            // Inserisco dentro l array della quantita il valore inserito prima
            quantitaDolci[i] = quantita;
            costoTotale += quantita * prezzoDolce;                                                           // EXTRA
           
        }

        //  Ciclo per il numero di dolci scelto e stampo prima l array con il nome e poi quello con la quantita
        System.out.println("\n Riepilogo ordinazione:");
        for (int i = 0; i < numeroDolci; i++) {
            System.out.println("# " + nomeDolci[i] + ": " + quantitaDolci[i] + " pezzo/i");
        }

        // Stampa del prezzo da pagare
        System.out.println(" Pezzo totale da pagare: "+ costoTotale + " Euro." );                               // EXTRA

        // Controllo se il cliente ha abbastanza soldi
        if (importoDisponibile >= costoTotale) {                                                                // EXTRA

            //se pago con piu soldi mi da il resto
            double resto = importoDisponibile - costoTotale;                                                    // EXTRA
            System.out.println(" Ordine confermato. Resto: "+ resto + " Euro.");

            // nel caso che mancano soldi mi dice quanti ne mancano
        } else {                                                                                                // EXTRA
            double mancano = costoTotale - importoDisponibile;
            System.out.println(" Fondi insufficienti. Mancano: "+ mancano + " Euro.");
        }

    }
}
