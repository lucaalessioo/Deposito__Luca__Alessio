import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Libreria libreria = new Libreria();
        ArrayList<User> listaUtenti = new ArrayList<>();       // lista dei vari utenti

        User utenteAttivo = null;

        int scelta;

        // menu di registrazione o accesso per l utente
        do {
            System.out.println("\n---- MENU PRINCIPALE ---");
            System.out.println("1. Registrazione utente");
            System.out.println("2. Login utente");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = Integer.parseInt(scanner.nextLine());    // utilizzo la conversione cosi da non dover creare un altro scanner

            // controllo la scelta dell utente 
            switch (scelta) {
                // caso per la registrazione
                case 1:
                    System.out.print("Inserisci username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Inserisci password: ");
                    String newPassword = scanner.nextLine();

                    // controllo username 
                    boolean esiste = false;
                    for (User u : listaUtenti) {                             // controllo se l username è stato gia creato 
                        if (u.username.equals(newUsername)) {                // se esiste imposto la variabile a true e interrompo il ciclo
                            esiste = true;
                            break;
                        }
                    }

                                                                                // se esiste è true l utente gia esiste 
                    if (esiste) {
                        System.out.println("Username già registrato.");
                                                                                // altrimenti aggiungo l utente alla lista degli usere
                    } else {
                        listaUtenti.add(new User(newUsername, newPassword));
                        System.out.println("Registrazione completata.");
                    }
                    break;                                                      // interrompo lo switch

                // Login
                case 2:                                             
                    System.out.print("Username: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Password: ");
                    String loginPass = scanner.nextLine();

                    // ciclo la lista degli utenti controllo quale utente ha le credenziali per entrare 
                    utenteAttivo = null;
                    for (User u : listaUtenti) {
                        if (u.username.equals(loginUser) && u.password.equals(loginPass)) {
                            utenteAttivo = u;       // imposto che l utente attivo è quello con le credenziali corrette
                            break;
                        }
                    }
                    
                    // nel caso le credenziali sono errate per tutti gli utenti in lista
                    if (utenteAttivo == null) {
                        System.out.println("Credenziali non valide.");
                    } else {
                        System.out.println("Benvenuto, " + utenteAttivo.username + "!");
                        menuUtente(scanner, libreria, utenteAttivo);                     // richiamo il metodo statico del menu per gli utenti se il login è andato a buon fine
                    }
                    break;

                case 0:                                                                     // uscita
                    System.out.println("Arrivederci!");
                    break;

                default:                                                                   // valore non valido 
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
    }

    // menu di ogni singolo utente 
    public static void menuUtente(Scanner scanner, Libreria libreria, User utente) {
        int scelta;
        do {
            System.out.println("\n--- MENU UTENTE ---");
            System.out.println("1. Aggiungi un libro");
            System.out.println("2. Visualizza tutti i libri");
            System.out.println("3. Prendi in prestito un libro");
            System.out.println("4. Restituisci un libro");
            System.out.println("5. Mostra libri presi");
            System.out.println("6. Controlla penalità");
            System.out.println("7. Simula passaggio giorni");
            System.out.println("0. Logout");
            System.out.print("Scelta: ");
            scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {

                // caso dell inserimento del libro
                case 1:
                    System.out.print("Titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Autore: ");
                    String autore = scanner.nextLine();
                    Book nuovoLibro = new Book(titolo, autore, true);                   // creo il libro da inserire
                    libreria.aggiungiLibro(nuovoLibro);                                             // aggiungo il libro alla lista
                    System.out.println("Libro aggiunto con successo.");
                    break;

                case 2:
                    libreria.mostraCatalogo();                                                      // visualizzo tutti i libri
                    break;

                case 3:                                                                             // Presa in prestito
                    System.out.print("Titolo del libro da prendere: ");
                    String libroDaPrendere = scanner.nextLine();
                    libreria.prestaLibro(utente, libroDaPrendere);
                    break;

                case 4:                                                                             // Caso di restituzione
                    System.out.print("Titolo del libro da restituire: ");
                    String libroDaRestituire = scanner.nextLine();
                    libreria.restituisciLibro(utente, libroDaRestituire);
                    break;

                case 5:                                                                             // Mostra i libri presi in prestito
                    utente.mostraLibriInPrestito();
                    break;

                case 6:                                                                             // Controlla penalita
                    utente.controllaPenalità();
                    break;

                case 7:                                                                             // simulazione del passaggio dei giorni
                    libreria.simulaPassaggioGiorni();                                               // con controllo ed aumento dei giorni su ogni libro che sta in prestito
                    System.out.println(" È passato un giorno per tutti i libri in prestito.");
                    break;

                case 0:                                                                             // LogOut
                    System.out.println("Logout completato.");
                    break;

                default:                                                                            // Scelta non valida
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);
    }
}



