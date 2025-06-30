import java.util.ArrayList;

public class Libreria {

    ArrayList<Book> catalogo;        // arraylist  di libri

    public Libreria() {
        catalogo = new ArrayList<>();
    }

    // metodo per aggiungere un libro
    public void aggiungiLibro(Book libro) {
        catalogo.add(libro);
    }

    // metodo per vedere quanti libri si hanno e per stampare ogni dettaglio di ogni libro
    public void mostraCatalogo() {
        
        if (catalogo.isEmpty()) {                           // se vuota
            System.out.println("La libreria è vuota.");
        } else {
            for (Book libro : catalogo) {               // se con libri
                libro.mostraInfo();
            }
        }
    }

    // metodo per cercare un libro specifico in base al titolo se lo trova lo restituisce senno restitutisce null
    public Book cercaLibro(String titolo) {
        for (Book libro : catalogo) {
            if (libro.titolo.equalsIgnoreCase(titolo)) {
                return libro;
            }
        }
        return null;
    }

    // metodo per prendere in prestito un libro
    public boolean prestaLibro(User utente, String titolo) {
        if (utente.libriInPrestito.size() >= 3) {                                                  // se l utente ha 3 libri ritorno false
            System.out.println("Hai già preso 3 libri. Usa metodo restituisciLibro. ");
            return false;
        }

        // creo una variabile di tipo libro su cui chiamo il metodo cercaLibro se torna null stampo non trovato
        Book libro = cercaLibro(titolo);
        if (libro == null) {
            System.out.println("Libro non trovato.");
            return false;
        }

        // se il libro non è disponibile stampo non disponibile
        if (!libro.disponibile) {
            System.out.println("Il libro non è disponibile.");
            return false;
        }

        // se non entra in nessuno dei due if precedenti imposto la disponibilita del  libro su false
        libro.disponibile = false;
        libro.giorniInPrestito = 0;                                                         // resetta il contatore quando il libro viene preso
        utente.libriInPrestito.add(libro);                                                  //aggiungo il libro nella lista dell utente
        System.out.println(utente.username + " ha preso in prestito: " + libro.titolo);
        return true;
    }

    // metodo per restituire un libro
    public boolean restituisciLibro(User utente, String titolo) {

        // ciclo la lista dei libri presi in prestito 
        for (Book libro : utente.libriInPrestito) {

            // controllo se il titolo inserito come parametro del metodo corrisponde al titolo del libro nella lista libri
            if (libro.titolo.equalsIgnoreCase(titolo)) {                    
                libro.disponibile = true;                       // imposto la disponibilita del libro su true
                libro.giorniInPrestito = 0;                     // azzero il contatore dei giorni di prestito       
                utente.libriInPrestito.remove(libro);           // rimuovo il libro dalla lista dell utente
                System.out.println("Libro restituito con successo.");
                return true;                                     // è andato tutto a buon fine quindi ritorno true
            }
        }
        System.out.println("Il libro non è presente tra quelli in prestito da " + utente.username);
        return false;                   // libro non presente nella lista
    }

    // metodo per simulare il passare dei giorni
    public void simulaPassaggioGiorni() {
        // ciclo il catalogo di libri
        for (Book libro : catalogo) {

            // controllo se il libro non è disponibile e nel caso incremento i giorni in prestito 
            if (!libro.disponibile) {
                libro.giorniInPrestito++; // simula il passare del tempo
            }
        }
    }
}
