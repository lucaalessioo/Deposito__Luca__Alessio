import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioStudenti {
    public static void main(String[] args) {
        Scanner interi = new Scanner(System.in);        // scanner per interi
        Scanner stringhe = new Scanner(System.in);      // scanner per stringhe
        ArrayList<Studente> listaStudenti = new ArrayList<>();      // lista di studenti
        int scelta;


        // menu studente
        do {
            System.out.println("\n--- MENU STUDENTI ---");
            System.out.println("1. Aggiungi studente");
            System.out.println("2. Stampa tutti gli studenti");
            System.out.println("3. Modifica voto studente per ID");
            System.out.println("4. Cerca studente per nome");
            System.out.println("5. Esci");
            System.out.print("Scegli: ");
            scelta = interi.nextInt();
           
            // INSERIMENTO
            if (scelta == 1) {
                System.out.print("Inserisci nome studente: ");
                String nome = stringhe.nextLine();

                System.out.print("Inserisci voto (0-10): ");
                int voto = interi.nextInt();
               

                Studente nuovoStudente = new Studente(nome, voto);
                listaStudenti.add(nuovoStudente);
                System.out.println("Studente aggiunto con successo!");

            // STAMPA DELLA LISTA
            } else if (scelta == 2) {
                if (listaStudenti.isEmpty()) {
                    System.out.println("Nessuno studente presente nella lista.");
                } else {
                    System.out.println("Eenco studenti: ");
                    for (int i = 0; i < listaStudenti.size(); i++) {
                        Studente s = listaStudenti.get(i);
                        s.stampaDettagli();
                        System.out.println("-------------------");
                    }
                }
            
            // RICERCA PER ID E SETTAGGIO DEL VOTO
            } else if (scelta == 3) {
                System.out.print("Inserisci l'ID dello studente da modificare: ");
                int id = interi.nextInt();
               

                boolean trovato = false;

                for (int i = 0; i < listaStudenti.size(); i++) {
                    Studente s = listaStudenti.get(i);                              // MI PRENDO OGNI STUDENTE AD OGNI CILCO
                    if (s.getIdStudente() == id) {                                  // CONTROLLO L ID
                        System.out.print("Inserisci nuovo voto: ");               // CHIEDO IL NUOVO VOTO
                        int nuovoVoto = interi.nextInt();
                       
                        s.setVoto(nuovoVoto);                                       // SETTO IL NUOVO VOTO
                        System.out.println("Voto aggiornato.");
                        trovato = true;                                             // TROVATO QUINDI TRUE
                        break;
                    }
                }

                // SE NON TROVATO
                if (!trovato) {
                    System.out.println("Studente con ID " + id + " non trovato.");
                }
            
            // RICERCA PER IL NOME E STAMPA DELLO STUDENTE
            } else if (scelta == 4) {
                System.out.print("Inserisci il nome dello studente da cercare: ");
                String nomeCercato = stringhe.nextLine();

                boolean trovato = false;

                for (int i = 0; i < listaStudenti.size(); i++) {                        // CICLO LA LISTA
                    Studente s = listaStudenti.get(i);                                  // MI PRENDO OGNI STUDENTE 
                    if (s.getNome().equalsIgnoreCase(nomeCercato)) {                    // CONTROLLO SE IL NOME é CORRETTO
                        System.out.println("Studente trovato:");
                        s.stampaDettagli();                                             // STAMPO I DETTAGLI
                        trovato = true;                                                 // STUDENTE TROVATO QUINDI IMPOSTO SU TRUE
                    }
                }

                // SE NON TROVATO 
                if (!trovato) {
                    System.out.println("Nessuno studente trovato con quel nome.");
                }
            
            // CHIUSURA DEL PROGRAMMA
            } else if (scelta == 5) {
                System.out.println("Arrivederci...");
            
            // SCELTA NON VALIDA
            } else {
                System.out.println("Scelta non valida. Riprova.");
            }

        } while (scelta != 5);

    }
}

    


 class Studente {

    // Variabili d'istanza private
    private String nome;
    private int voto;
    private int idStudente;  // ID unico per ogni oggetto

    private static int contatoreId = 1;  // contatore statico

    // Costruttore
    public Studente(String nome, int voto) {
        this.nome = nome;
        setVoto(voto); // usa setter per validazione
        this.idStudente = contatoreId++;
    }

    // Getter
    public String getNome() {
        return nome;
    }

    public int getVoto() {
        return voto;
    }

    public int getIdStudente() {
        return idStudente;
    }

    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVoto(int voto) {
        controlloVoto(voto);
    }

    // Metodo privato per validare il voto
    private void controlloVoto(int voto) {
        if (voto >= 0 && voto <= 10) {
            this.voto = voto;
        } else {
            System.out.println("Valore del voto sbagliato! Deve essere tra 0 e 10.");
        }
    }

    // Metodo per stampare i dettagli dello studente
    public void stampaDettagli() {
        System.out.println("ID Studente: " + idStudente);
        System.out.println("Nome: " + nome);
        System.out.println("Voto: " + voto);
    }
}