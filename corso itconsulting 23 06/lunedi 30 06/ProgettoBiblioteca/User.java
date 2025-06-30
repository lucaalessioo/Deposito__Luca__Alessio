import java.util.ArrayList;

public class User {

    // Variabili d istanza dell user
    String username;
    String password;
    ArrayList<Book> libriInPrestito;

    // costruttore personalizzato user
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.libriInPrestito = new ArrayList<>();
    }

    // metodo per vedere quanti libri si hanno in prestito
    public void mostraLibriInPrestito() {

        // se vuoto non ho libri
        if (libriInPrestito.isEmpty()) {
            System.out.println(username + " non ha libri in prestito.");

            // altrimenti stampa i libri che si hanno
        } else {
            System.out.println("Libri in prestito per " + username + ":");
            for (Book libro : libriInPrestito) {
                System.out.println("- " + libro.titolo + " (Giorni in prestito: " + libro.giorniInPrestito + ")");
            }
        }
    }

    // metodo per controllare la penalita 
    public void controllaPenalità() {
        // variabile di controllo impostata su false
        boolean penalitàTrovate = false;

        // ciclo la lista  di libri presi 
        for (Book libro : libriInPrestito) {

            // controllo da quanti giorni ho un determinato libro se supera 14 imposto la penalita
            if (libro.giorniInPrestito > 14) {
                System.out.println(" Penale per '" + libro.titolo + "' - oltre i 14 giorni!");
                penalitàTrovate = true;
            }
        }
        // se la penalita sta su false allora non applico nulla
        if (!penalitàTrovate) {
            System.out.println("Nessuna penalità per " + username);
        }
    }
}
