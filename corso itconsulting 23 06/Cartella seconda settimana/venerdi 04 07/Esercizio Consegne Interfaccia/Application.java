import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
         List<Veicolo> veicoli = new ArrayList<>();
        Scanner interi = new Scanner(System.in);
        Scanner stringhe = new Scanner(System.in);


        // Aggiungi veicolo
        System.out.println("Aggiungi un veicolo: (1 = Furgone, 2 = Drone)");
        int scelta = interi.nextInt();
        

        Veicolo veicolo = null;         // Inizialmente nullo poi assegno in base alla scelta dell utente furgone o drone

        // Input targa e carico massimo
        System.out.print("Inserisci targa: ");
        String targa = stringhe.nextLine();
        System.out.print("Inserisci carico massimo: ");
        float caricoMax = interi.nextFloat();
        stringhe.nextLine(); 

        // Crea il veicolo scelto
        if (scelta == 1) {
            veicolo = new Furgone();
        } else if (scelta == 2) {
            veicolo = new Drone();
        }

        // Imposta i dati
        veicolo.setTarga(targa);                // imposto la targa data dall utente
        veicolo.setCaricoMassimo(caricoMax);    // imposto il carico dato dall utente
        veicoli.add(veicolo);                   // aggiungo il veicolo alla lista

        // Input destinazione e peso pacco
        System.out.print("Inserisci destinazione: ");
        String destinazione = stringhe.nextLine();
        System.out.print("Inserisci peso pacco (kg): ");
        float pesoPacco = interi.nextFloat();
        

        // Esegui la consegna con controllo del peso
        veicolo.consegnaPacco(destinazione, pesoPacco);

        // Se il veicolo è tracciabile, traccia la consegna
        if (veicolo instanceof TracciabileInterface) {
            System.out.print("Inserisci codice tracking: ");
            String codiceTracking = stringhe.nextLine();
             veicolo.tracciaConsegna(codiceTracking);
        }

        interi.close();
        stringhe.close();
    }
}
