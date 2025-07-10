import java.util.Scanner;

public class VotiStudenteExtra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vuoi inserire un altro studente? (sì/no): imposto su si per il primo ciclo
        String risposta = "sì";

        // ciclo portante del programma se diverso da no, quindi se si risponde si parte il ciclo fino a che non si inserisce no
        while (!risposta.equalsIgnoreCase("no")) {
            // Chiedo il nome dello studente
            System.out.print("Inserisci il nome dello studente: ");
            String nomeStudente = scanner.nextLine();


            // Chiedo quanti voti inserire con controllo
            System.out.print("Quanti voti vuoi inserire per " + nomeStudente + "? ");
            int numeroVoti = scanner.nextInt();

            // Controllo se il numero di voti è maggiore di 0
            while (numeroVoti <= 0) {
                System.out.println("Errore: inserisci un numero intero positivo.");
                System.out.print("Quanti voti vuoi inserire per " + nomeStudente + "? ");
                numeroVoti = scanner.nextInt();
            }

            int votiValidi = 0;  // Variabile per vedere quanti voti inseriti sono validi
            int sommaVoti = 0;   // Variabile per calcolare la media

            // Inserimento dei voti
            for (int i = 1; i <= numeroVoti; i++) {

                int voto = -1;  // faccio partire il voto con un numero negativo cosi che entra all interno del while

                // ho fatto il while per non sprecare l iterazione del for
                while (voto < 0 || voto > 30) {
                    System.out.print("Inserisci il voto : (da 0 a 30): ");
                    voto = scanner.nextInt();

                    // controllo di nuovo se il voto inserito ora è corretto se non corretto lo richiedo sopra
                    if (voto < 0 || voto > 30) {
                        System.out.println("Voto non valido. Deve essere tra 0 e 30.");
                    }
                }

                // Incremento i voti validi
                votiValidi++;

                sommaVoti += voto; // Aggiungo il voto alla variavile somma voti

                // Assegno la stampo in base al voto 
                if (voto >= 24) {
                    System.out.println("Voto buono o ottimo.");
                } else if (voto >= 18) {
                    System.out.println("Voto sufficiente.");
                } else {
                    System.out.println("Voto insufficiente.");
                }
            }

            // Calcolo la media 
            double media = (double) sommaVoti / votiValidi;  // divido la somma di tutti i voti per i voti validi

            // stampo il nome dello studente il totale dei voti e la media dei voti 
            System.out.println("\nStudente: " + nomeStudente);
            System.out.println("Numero totale di voti validi: " + votiValidi);
            System.out.println("Media dei voti: " + media);

            scanner.nextLine(); 

            // chiedo se inserire un altro studente 
            System.out.print("Vuoi inserire un altro studente? (sì/no): ");
            risposta = scanner.nextLine();
        }

        System.out.println("Programma terminato. Arrivederci!");
        
    }
}
