class Libro {

    //Variabili d istanza
    String titolo;
    String nomeAutore;
    double prezzo;

    // variabile statica per la classe
    static int numeroLibri;

    // costruttore 
    public Libro(String titolo , String nomeAutore , double prezzo) {
        this.titolo = titolo;
        this.nomeAutore = nomeAutore;
        this.prezzo = prezzo;
        numeroLibri++;          // incremente la variabile statica ad ogni creazione 

    }

    // metodo per mostrare i dattagli del libro
    public void mostraDettagli() {
        System.out.println("Il titolo del libro è: " + titolo + "Il nome dell autore è : " + nomeAutore + "il prezzo è: " + prezzo );
    }

    // metodo per stampare la variabile statica 
    public static void stampaContatore() {
        System.out.println(" il numero di Libri creati sono : " + numeroLibri);
    }
}

public class EsercizioLibro {
    public static void main(String[] args) {

        // creo due oggetti libro
        Libro libro1 = new Libro("Signore degli anelli", "Marco", 10.50);
        Libro libro2 = new Libro("Harry potter", "Marco", 20.50);

        // richiamo i metodo per la stampa dei dettagli su entrambi i libri
        libro1.mostraDettagli();
        libro2.mostraDettagli();

        // richiamo il metodo per la stampa della variabile statica
        Libro.stampaContatore();
    }
}
