import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


// ESERCIZIO GESTIONE STUDENTI CON ELIMINAZIONE MULTIPLA DI STUDENTI

public class ProvaModifica {
    public static void main(String[] args) {

        Scanner interi = new Scanner(System.in);                // Scanner per interi
        Scanner stringhe = new Scanner(System.in);              // Scannerp per stringhe
        ArrayList<String> listaNomi = new ArrayList<>();

        String verifica;                // Variabile di verifica del do 

        // Ciclo per chiedere l inserimento dei nomi degli studenti
        do {
            System.out.println("Inserisci il nome dello studente: ");
            String nome = stringhe.nextLine();
            verifica = nome;

            // Se il nome è diverso da fine aggiunge il nome all arraylist
            if(!(nome.equals("fine"))) {
        
                listaNomi.add(nome);
                Collections.sort(listaNomi);      // Ordinamento alfabetico
            }


        } while(!(verifica.equalsIgnoreCase("fine")));     // Se scrivo fine esce dal do

        // Stampa dei nomi della lista
        for(String nomi : listaNomi) {
            System.out.println("Nome: " + nomi);
        }
        
        System.out.println("Studenti inseriti: "+listaNomi.size());         // Stampo il numero di studenti inseriti

        System.out.println("Vuoi eliminare uno studente ? (s/n) ");       // Chiedo se si vuole eliminare uno studente 
        String risposta = stringhe.nextLine();

        if (risposta.equalsIgnoreCase("s")) {                  // Se la risposta è s 
            System.out.println("Quanti studenti vuoi eliminare?");         // Chiedo quanti studenti eliminare
            int numeroDaEliminare = interi.nextInt();

            ArrayList<Integer> indiciDaEliminare = new ArrayList<>();       // Creo un arraylist dove salvare gli indici da eliminare

            for (int i = 0; i < numeroDaEliminare; i++) {                     // ciclo per il numero dei studenti da eliminare ( numeroDaEliminare )
                System.out.println("Inserisci l'indice dello studente da eliminare :");
                int indice = interi.nextInt();

                while (indice < 1 || indice > listaNomi.size() ) {              // Controllo se l indici è corretto senno lo richiedo
                    System.out.println("Indice non valido o già inserito. Riprova:");
                    indice = interi.nextInt();
                }

                indiciDaEliminare.add(indice - 1);                  // Aggiunta degli indici da eliminare  nell arraylist
            }

            for (int indice : indiciDaEliminare) {                  // Rimozione degli studenti con stampa
                String rimosso = listaNomi.remove(indice);
                System.out.println("Rimosso: " + rimosso);
            }
        } else {
            System.out.println("Programma finito!");
        }

      System.out.println(" ------------------------ ");

      System.out.println("Lista Aggiornata :");             // Stampa lista aggiornata
        // Stampa lista aggiornata
        for(String stampaNomi : listaNomi) {
            System.out.println(stampaNomi);
        }

    }

}
