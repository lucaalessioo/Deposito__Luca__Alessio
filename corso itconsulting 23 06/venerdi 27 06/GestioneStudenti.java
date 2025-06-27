import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

// GESTIONE DEGLI STUDENTI CON UNA SINGOLA ELIMINAZIONE DI UN SINGOLO STUDENTE
public class GestioneStudenti {
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

        if(risposta.equalsIgnoreCase("s")) {                   // se si chiedo l indice 
            System.out.println("quale studente desideri eliminare ? dammi l indice: ");
            int indice = interi.nextInt();
            

            while (indice > listaNomi.size()) {                     // Controllo se l indice è corretto senno lo richiedo 
                System.out.println("indice errato! ");
                System.out.println("Inserisci di nuovo l indice: ");
                indice = interi.nextInt();
            }
             listaNomi.remove(indice -1);                   // Rimuove il nome associato a quell indice

        } else if(risposta.equalsIgnoreCase("n")) {     // se scrivo n il programma si chiude e stampo la lista aggiornata
            System.out.println("Programma finito! ");
        }

        // Stampa lista aggiornata
        for(String stampaNomi : listaNomi) {
            System.out.println(stampaNomi);
        }

    }

}