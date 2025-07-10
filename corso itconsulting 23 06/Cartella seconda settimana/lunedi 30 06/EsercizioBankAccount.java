import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioBankAccount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Utente> utentiRegistrati = new ArrayList<>(); // ArrayList di utenti

        // ciclo infinito per la scelta iniziale
        while (true) {
            System.out.println("\nBenvenuto nel conto bancario!");
            System.out.println("1. Accedi");
            System.out.println("2. Registrati");
            System.out.println("3. Esci");
            System.out.print("Scegli: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            // scelta 1 quindi Accedi
            if (scelta == 1) {
                System.out.print("Inserisci username: ");
                String username = scanner.nextLine();
                System.out.print("Inserisci password: ");
                String password = scanner.nextLine();

                // inizializzo a null una variabile di tipo Utente da usare nel controllo dopo
                Utente utenteTrovato = null;
                for (Utente u : utentiRegistrati) {
                    // se le credenziali sono corrette allora imposto la variabile creata prima con
                    // la variabile all interno del for e stoppo la ricerca dell utente
                    if (u.username.equals(username) && u.password.equals(password)) {
                        utenteTrovato = u;
                        break; // basta che trova 1 corrispondenza quindi interrompo il ciclo
                    }
                }

                // se l utente trovatrovato non è null allora i login è andato a buon fine
                // quindi apro il menu delle operazioni da fare nel conto
                if (utenteTrovato != null) {
                    System.out.println("Accesso riuscito. Benvenuto, " + utenteTrovato.nome + "!");
                    menuConto(scanner, utenteTrovato.conto);
                } else {
                    System.out.println("Credenziali errate.");
                }

                // scelta di registrazione
            } else if (scelta == 2) {
                boolean usernameEsiste;

                do {
                    // chiedi i dati all utente
                    System.out.print("Inserisci il tuo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Scegli uno username: ");
                    String username = scanner.nextLine();
                    System.out.print("Scegli una password: ");
                    String password = scanner.nextLine();

                    // inizializzo a false la variabile di controllo
                    usernameEsiste = false;

                    // Ciclo la lista di utenti 
                    for (Utente u : utentiRegistrati) {

                        // controllo se username esiste se si imposto la variabile su true quindi non
                        if (u.username.equals(username)) {
                            usernameEsiste = true;      // imposto su true se l username gia esiste
                            System.out.println("Username già in utilizzo! Riprova...\n");
                            break;
                        }
                    }

                    // se username non esiste completo la registrazione
                    if (!usernameEsiste) {
                        Utente nuovoUtente = new Utente(nome, username, password, 0.0);
                        utentiRegistrati.add(nuovoUtente);
                        System.out.println("Registrazione completata!");
                    }

                } while (usernameEsiste); // continua il ciclo finche ci sta un utente gia registrato con quelle credenziali
            }

            // uscita dal programma di gestione conto
            else if (scelta == 3) {
                System.out.println("Uscita dal programma.");
                break;
            } else {
                System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }

    // metodo per il menu della carta
    public static void menuConto(Scanner scanner, ContoBancario conto) {
        while (true) {
            System.out.println("\nMENU CONTO");
            System.out.println("1. Deposita");
            System.out.println("2. Preleva");
            System.out.println("3. Mostra saldo");
            System.out.println("4. Esci al menu principale");
            System.out.print("Scegli: ");
            int scelta = scanner.nextInt();

            // aggiungo denaro
            if (scelta == 1) {
                System.out.print("Inserisci importo da depositare: ");
                double importo = scanner.nextDouble();
                conto.deposita(importo);

                // prelievo
            } else if (scelta == 2) {
                System.out.print("Inserisci importo da prelevare: ");
                double importo = scanner.nextDouble();
                conto.preleva(importo);

                // visualizzazione saldo
            } else if (scelta == 3) {
                conto.mostraSaldo();

                // uscita dal menu
            } else if (scelta == 4) {
                break;
            } else {
                System.out.println("Scelta non valida.");
            }
        }
    }
}

// classe contobancario con la gestione delle operazioni 
class ContoBancario {
    private double saldo;

    // Costruttore
    public ContoBancario(double saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    // Metodo per dopositare
    public void deposita(double importo) {
        if (importo > 0) {
            saldo += importo;
            System.out.println("Hai depositato: " + importo + " euro");
        } else {
            System.out.println("Importo non valido.");
        }
    }

    // Metodo per prelevare
    public void preleva(double importo) {
        if (importo <= 0) {
            System.out.println("Importo non valido.");
        } else if (importo > saldo) {
            System.out.println("Saldo insufficiente.");
        } else {
            saldo -= importo;
            System.out.println("Hai prelevato: " + importo + " euro");
        }
    }

    // Metodo per visualizzare il saldo
    public void mostraSaldo() {
        System.out.println("Saldo attuale: " + saldo + " euro");
    }
}

// classe utente per la gestione dell utente 
class Utente {
    String nome;
    String username;
    String password;
    ContoBancario conto; // Oggetto di tipo ContoBancario

    // Costruttore
    public Utente(String nome, String username, String password, double saldoIniziale) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.conto = new ContoBancario(saldoIniziale); // Per ogni utente creato gli assegno un proprio conto bancario
    }
}