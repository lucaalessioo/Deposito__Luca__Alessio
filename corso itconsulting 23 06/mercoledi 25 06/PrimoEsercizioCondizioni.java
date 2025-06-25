import java.util.Scanner;

public class PrimoEsercizioCondizioni {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        // Scelta del mezzo di trasporto
        System.out.println("Scegli il mezzo di trasporto : (Taxi / Bus)");
        String scelta = scanner.nextLine();

        // Variabile booleana per il controllo dell'accesso
        boolean accessoConsentito = false;
        
        // Condizione in base al mezzo di trasporto scelto
        if (scelta.equalsIgnoreCase("Taxi")) {
            int denaro = 160;
            System.out.println("Hai: " + denaro + " Euro");

            // Se il cliente ha scelto il taxi
            System.out.print("Inserisci i chilometri da percorrere: ");
            int chilometri = scanner.nextInt();
            double prezzoKm = 1.5; // Prezzo medio per chilometro
            double prezzoTotale = chilometri * prezzoKm;

            // controllo se il denaro è abbastanza per la distanzada percorrere se true accesso consentito altrimenti non sale sul taxi
            if(denaro >= chilometri * prezzoKm) {
            System.out.println("Il prezzo del viaggio in taxi è: " + prezzoTotale + " Euro.");
            accessoConsentito = true;

            // setto il denaro rimanente
            denaro -= chilometri * prezzoKm;
            System.out.println("Denaro rimanente: "+denaro+ " Euro");
            
            } else System.out.println("non hai abbastanza soldi.");

            // Se il cliente ha scelto il bus -----------------------------------------------------------
        } else if (scelta.equalsIgnoreCase("Bus")) {
            // Chiedo età
            System.out.print("Inserisci la tua età: ");
            int eta = scanner.nextInt();
            
            // Controllo biglietto
            System.out.print("Hai il biglietto? (true/false): ");
            boolean bigliettoValido = scanner.nextBoolean();
            
            // Controllo se accompagnato
            System.out.print("Sei accompagnato da una persona adulta? (true/false): ");
            boolean accompagnato = scanner.nextBoolean();
            
            // Chiedo se ha il saltafila
            System.out.print("Hai acquistato l'opzione per saltare la fila? (true/false): ");
            boolean saltaFila = scanner.nextBoolean();
            
            // Controllo accesso per il bus
            if (bigliettoValido && (eta >= 18 || accompagnato)) {
                if (saltaFila) {
                    accessoConsentito = true;
                    System.out.println("Puoi passare saltando la fila per il bus.");
                } else {
                    accessoConsentito = true;
                    System.out.println("Puoi passare ma devi fare la fila per il bus.");
                }
            }
            // Controllo per le varie stampe
            else if(accompagnato == false && eta < 18 && bigliettoValido == false) {
                System.out.println("Non puoi passare perche non sei accomagnato, non hai il biglietto valido e non sei maggiorenne! "); 
            }
            else if(accompagnato == false && eta < 18) {
                System.out.println(" Non puoi passare perche sei minorenne e non accompagnato! ");
            } else if(bigliettoValido == false) {
                System.out.println("Non puoi salire perche non hai il biglietto! ");
            }

        } else {
            System.out.println("Scelta non valida.");
        }

        // Stampa il risultato finale in base alla variabile booleana creata prima per il controllo dell accesso
        if (accessoConsentito) {
            System.out.println("Accesso consentito!");
        } else {
            System.out.println("Accesso negato.");
        }

        scanner.close();
    }
}
