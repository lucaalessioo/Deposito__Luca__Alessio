import java.util.Scanner;

class Persona {
    String nome;
    String citta; 
    int eta;

    Persona(String nome, String citta) {
        this.nome=nome;
        this.citta=citta;
        eta =20;
    }

    public void mostraDettagli() {
        System.out.println("Il nome della persona è: " + nome + "\nLa citta di appartenenza è : " + citta + "\nL'eta è di : " + eta + " Anni.");
    }
}

public class EsercizioPersona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String scelta ;
         while (true) {
            System.out.println("Vuoi creare una persona? (si/no)");
            scelta = scanner.nextLine().trim().toLowerCase();

            if (scelta.equals("no")) {
                System.out.println("Programma terminato.");
                break;
            } else if (scelta.equals("si")) {
                System.out.println("Inserisci il nome della persona: ");
                String nome = scanner.nextLine();

                System.out.println("Inserisci la città: ");
                String citta = scanner.nextLine();

                Persona persona = new Persona(nome, citta);
                persona.mostraDettagli();
            } else {
                System.out.println("Risposta non valida. Digita 'si' o 'no'.");
            }
        }
    }
}
