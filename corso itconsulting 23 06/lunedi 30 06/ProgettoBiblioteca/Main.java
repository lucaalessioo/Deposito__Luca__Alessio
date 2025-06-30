import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Libreria libreria = new Libreria();
        ArrayList<User> utenti = new ArrayList<>();

        User utenteAttivo = null;

        int scelta;

        // menu di registrazione o accesso per l utente
        do {
            System.out.println("\n---- MENU PRINCIPALE ---");
            System.out.println("1. Registrazione utente");
            System.out.println("2. Login utente");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Inserisci password: ");
                    String newPassword = scanner.nextLine();

                    // controllo username unico
                    boolean esiste = false;
                    for (User u : utenti) {
                        if (u.username.equals(newUsername)) {
                            esiste = true;
                            break;
                        }
                    }

                    if (esiste) {
                        System.out.println("Username già registrato.");
                    } else {
                        utenti.add(new User(newUsername, newPassword));
                        System.out.println("Registrazione completata.");
                    }
                    break;

                case 2:
                    System.out.print("Username: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Password: ");
                    String loginPass = scanner.nextLine();

                    utenteAttivo = null;
                    for (User u : utenti) {
                        if (u.username.equals(loginUser) && u.password.equals(loginPass)) {
                            utenteAttivo = u;
                            break;
                        }
                    }

                    if (utenteAttivo == null) {
                        System.out.println("Credenziali non valide.");
                    } else {
                        System.out.println("Benvenuto, " + utenteAttivo.username + "!");
                        menuUtente(scanner, libreria, utenteAttivo);
                    }
                    break;

                case 0:
                    System.out.println("Arrivederci!");
                    break;

                default:
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
                case 1:
                    System.out.print("Titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Autore: ");
                    String autore = scanner.nextLine();
                    Book nuovoLibro = new Book(titolo, autore, true);
                    libreria.aggiungiLibro(nuovoLibro);
                    System.out.println("Libro aggiunto con successo.");
                    break;

                case 2:
                    libreria.mostraCatalogo();
                    break;

                case 3:
                    System.out.print("Titolo del libro da prendere: ");
                    String libroDaPrendere = scanner.nextLine();
                    libreria.prestaLibro(utente, libroDaPrendere);
                    break;

                case 4:
                    System.out.print("Titolo del libro da restituire: ");
                    String libroDaRestituire = scanner.nextLine();
                    libreria.restituisciLibro(utente, libroDaRestituire);
                    break;

                case 5:
                    utente.mostraLibriInPrestito();
                    break;

                case 6:
                    utente.controllaPenalità();
                    break;

                case 7:
                    libreria.simulaPassaggioGiorni();
                    System.out.println(" È passato un giorno per tutti i libri in prestito.");
                    break;

                case 0:
                    System.out.println("Logout completato.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);
    }
}



