import java.util.Scanner;

public class EsercizioCicli1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Password di default
        String password = "java123";

        // Chiedo la password dentro ad u n cilco while
        int contatore=0;

        // ciclo while per i 3 possibili inserimenti della password
        while(contatore < 3 ) {
        System.out.println("Inserisci la password");
        String passwordInserita = scanner.nextLine();
        
        // Controllo se la password inserita è corretta stampo accesso consentito
        if(passwordInserita.equals(password)) {
            System.out.println("Accesso consentito");
             
            // Creo un ciclo do while per controllare se si vuole accedere o no al sistema
            String controllo;
            do {
                System.out.println("Vuoi accedere al sistema ? s/n ");
                String inserimento = scanner.nextLine();
                controllo = inserimento;

                // Se si digita s stampo accesso al sistema effettuato e interrompo il programma
                if(inserimento.equalsIgnoreCase("s")) {
                    System.out.println("accesso al sistema effettuato! ");
                    return;
                }
                 // Se si digita n stampo accesso al sistema annullato e interrompo il programma
                else if(inserimento.equalsIgnoreCase("n")) {
                    System.out.println("accesso al sistema annullato! ");
                    return;
                }
                // Condizione del do che dice continua fino a che l inserimento è diverso da quei due valori
            }while(controllo != "s" || controllo != "n");
        }
        // Contatore dei tentativi per l iserimento della password
        contatore++;
    }
    System.out.println("Accesso Bloccato");
    
    }
}
