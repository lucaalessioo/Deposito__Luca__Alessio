public class Book {

    //variabili d istanza per il book
    String titolo;
    String autore;
    boolean disponibile;
    int giorniInPrestito = 0; // contatore fittizio

    // costruttore
    public Book(String titolo, String autore, boolean disponibile) {
        this.titolo = titolo;
        this.autore = autore;
        this.disponibile = disponibile;
    }  

    // Metodo per visuallizare tutte le info con operatore ternario di verifica
    public void mostraInfo() {
        String stato = disponibile ? "Disponibile" : "Non disponibile";
        System.out.println("Titolo: " + titolo + " | Autore: " + autore + " | Stato: " + stato);
    }

    @Override
    public String toString() {
        return "Libro [Titolo='" + titolo + "', Autore='" + autore + "', Disponibile=" + disponibile + "]";
    }
}