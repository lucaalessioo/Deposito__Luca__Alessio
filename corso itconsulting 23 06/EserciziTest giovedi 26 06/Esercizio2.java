import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> spesa = new ArrayList<>();     // Dichiarazione con inizializzazione di un arraylist

        System.out.println("Scrivi cosa devi comprare. Digita 'fine' per chiudere la lista.");                  // chiedo all utente di inserire i prodotti

        String inserimento;
        boolean colazioneOK = false;     // variabile booleana per controllare se ha pensato alla colazione

        while (true) {              // ciclo infinito per inserimento prodotti fino a che non si inserisci la stringa fine
            System.out.print("- ");
            inserimento = scanner.nextLine(); 

            if (inserimento.equals("fine")) {   
                break;                                  // interrompoi l inserimento se scrivo fine
            }

            spesa.add(inserimento);      // Inserisco all interno di spesa cio che inserisce l utente
        }

        System.out.println("--- LISTA DELLA SPESA ---");
        for (String prodotto : spesa) {
            System.out.println("* " + prodotto);
        }

        System.out.println("Totale prodotti: " + spesa.size());     // Stampo il numero di prodotti presi

        // Controlli sulla  colazione
        if (spesa.contains("pane") && spesa.contains("latte")) {         // se li inserisce entrambi stampo hai pensato alla colazione 
            System.out.println(" Hai pensato alla colazione!");
        } else if (spesa.contains("pane") || spesa.contains("latte")) {         // se ne manca uno stampo che manca qualcosa 
            System.out.println(" Ti manca qualcosa per la colazione.");
        } else {
            System.out.println(" Nessun articolo per la colazione.");               // altrimenti nessun articolo
        }

        scanner.close();
    }
}
