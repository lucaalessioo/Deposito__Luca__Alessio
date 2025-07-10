import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioFinaleOggettiOfficina {

    public static void main(String[] args) {

        Scanner interi = new Scanner(System.in); // Scanner per interi
        Scanner stringhe = new Scanner(System.in); // scanner per stringhe
        Officina officina = new Officina();

        // variabile per l uscita dal do
        int controllo;
        do {
            // menu officina
            System.out.println("\n--- Benvenuto nella mia officina! ---");
            System.out.println("1. Inserisci una nuova auto.");
            System.out.println("2. Rimuovi Auto.");
            System.out.println("3. Stampa dettagli auto.");
            System.out.println("4. Stampa numero di auto create");
            System.out.println("5. Esci.");
            System.out.println("Scegli: ");

            int scelta = interi.nextInt();
            controllo = scelta;

            // controllo la scelta
            switch (scelta) {

                // Inserisci i dati dell auto
                case 1:
                    System.out.println("Ok. Sei nella sezione per aggiungere un auto!");
                    System.out.println("Inserisci la targa: ");
                    String targa = stringhe.nextLine();
                    System.out.println("Inserisci il modello: ");
                    String modello = stringhe.nextLine();

                    Auto auto1 = new Auto(targa, modello);

                    officina.aggiungiAuto(auto1); // aggiungo l auto
                    

                    break;

                // Rimozione Auto
                case 2:
                    System.out.println("Ok. Sei nella sezione per rimuovere un auto!");
                    System.out.println("Inserisci la targa dell auto che vuoi rimuovere: ");
                    String targa2 = stringhe.nextLine();
                    officina.rimuoviAuto(targa2); // Rimuovo l auto
                    break;

                // Stampo i dettagli
                case 3:
                    System.out.println("Sezione stampa dettagli! ");
                    System.out.println();
                    officina.stampaAuto();
                    break;

                // stampa quante auto sono state create
                case 4:
                    System.out.println("Sezione per vedere quante auto sono state create. ");
                    System.out.println();
                    Officina.stampaContatore();
                    break;
            }

        } while (controllo != 5);

    }
}

// Classe Auto
class Auto {

    // Variabili d istanza
    String targa;
    String modello;
    static int contatore = 0; // contatore per vedere quante auto sono state create

    Auto(String targa, String modello) {

        this.targa = targa;
        this.modello = modello;
        contatore++;
    }

    // Metodo per stampare i dettagli dell auto
    public void stampaDettagli() {
        System.out.println("Targa auto: " + targa + "\nModello Auto: " + modello);
    }
}

class Officina {
    ArrayList<Auto> listaAuto = new ArrayList<>();


    // metodo per aggiungere un auto alla lista auto
   public void aggiungiAuto(Auto auto) {
    boolean targaEsistente = false;
    for (Auto a : listaAuto) {                          // ciclo la lista
        if (a.targa.equalsIgnoreCase(auto.targa)) {     // controllo se la targa è presente
            targaEsistente = true;                      // imposto su true la variabile se l auto gia esiste
            break;
        }
    }

    // se esiste stampo errore
    if (targaEsistente) {
        System.out.println("La targa è già stata inserita. Non puoi inserire una targa già presente!");

    // altrimenti aggiungo l auto
    } else {    
        listaAuto.add(auto);               

        System.out.println("Auto aggiunta con successo.");
    }
}
        
    

    // Metodo per la rimozione di un auto
    public void rimuoviAuto(String targa) {
        for (Auto auto : listaAuto) {

            // controllo se la targa coincide
            if (auto.targa.equalsIgnoreCase(targa)) {
                listaAuto.remove(auto); // Rimuovo l auto
                System.out.println("Auto rimossa! ");
            } else {
                System.out.println("Auto non trovata! "); // Auto non trovata
            }
        }

    }

    // Metodo per stampare tutte le auto presenti
    public void stampaAuto() {

        // se la lista è vuota stampo lista vuota
        if (listaAuto.isEmpty()) {
            System.out.println("Lista Vuota.");
        } else { // altrimenti
            for (Auto auto : listaAuto) { // stampo i dettagli di ogni macchina
                auto.stampaDettagli();
                System.out.println("-----------");
            }
        }
    }

    // Metodo per stampare il numero di auto create
    public static void stampaContatore() {
        System.out.println("Sono state create: " + Auto.contatore + " Auto");
    }
}