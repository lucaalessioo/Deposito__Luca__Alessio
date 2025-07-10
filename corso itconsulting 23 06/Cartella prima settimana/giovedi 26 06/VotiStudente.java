import java.util.Scanner;

public class VotiStudente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Numero dei voti validi
        int votiValidi = 0;

        // Chiedo quanti voti si vogliono inserire
        System.out.println("Quanti voti vuoi inserire ?");
        int numeroVoti = scanner.nextInt();

        // Ciclo while per controllare se il numero di voti è maggiore di 0
        while(numeroVoti <= 0) {
            System.out.println("Inserisci un numero maggiore di 0");
             System.out.print("Quanti voti vuoi inserire? ");
             numeroVoti = scanner.nextInt();
        }

        // ciclo for per l inserimento dei voti (parto da 1 perche senno me lo chiede una volta in piu se partissi da 0 )
        for(int i = 1; i <= numeroVoti; i++) {
            System.out.println("Inserisci i voti: ");
            int voto = scanner.nextInt();

            // ciclo while per controllare se i voti inseriti sono un numero compreso tra 0 e 30 
            while (voto < 0 || voto > 30) {
                System.out.print("Inserisci il voto : (da 0 a 30): ");  // inserisco i voti
                voto = scanner.nextInt();

                // Controllo se i voti sono stati inseriti bene questa volta
                if (voto < 0 || voto > 30) {
                    System.out.println("Voto non valido. Deve essere tra 0 e 30.");
            }
        }   
        //  se arrivati qui voti validi quindi incremento il numero di voti validi 
         votiValidi++;

         // Controllo che tipo di voto mi è arrivato e gli assegno la rispettiva stampa 
           if (voto >= 24) {
                System.out.println("Voto buono o ottimo.");
            } else if (voto >= 18) {
                System.out.println("Voto sufficiente.");
            } else {
                System.out.println("Voto insufficiente.");
            }
        }
         System.out.println("Numero totale di voti validi inseriti: " + votiValidi);
    }
}
