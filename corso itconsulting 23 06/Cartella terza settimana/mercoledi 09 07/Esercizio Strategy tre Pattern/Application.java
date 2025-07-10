import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        // Ottengo l'unico Gestore Pagamenti (Kit Singleton)
        GestorePagamenti gestorePagamenti = GestorePagamenti.getIstanza();

        // Registro chi deve essere avvisato (Kit Observer)
        gestorePagamenti.aggiungiOsservatore(new LogDiPagamento()); // Stampa per log
        gestorePagamenti.aggiungiOsservatore(new ConfermaUtente()); // Stampa per l utente

        System.out.println("Ciao! Scegli un'operazione per il pagamento.");

        while (true) {
            System.out.print("\nQuanto vuoi pagare? (Inserisci 0 per uscire): ");
            double importo = scanner.nextDouble();
            scanner.nextLine(); 

            if (importo <= 0) {
                System.out.println("Arrivederci!");
                break;
            }

            System.out.println("Come vuoi pagare?");
            System.out.println("1. Carta di Credito");
            System.out.println("2. PayPal");
            System.out.print("Scegli (1 o 2): ");
            String sceltaMetodo = scanner.nextLine();

            MetodoDiPagamento metodoScelto = null; // Il metodo da usare (Kit Strategy)

            switch (sceltaMetodo) {
                case "1":
                    metodoScelto = new CartaDiCredito(); // Creo un nuovo ogetto carta di credito e lo assegno al metodo di pagamento
                    break;
                case "2":
                    metodoScelto = new PayPal(); // Creo un nuovo ogetto PayPal e lo assegno al metodo di pagamento
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
                    continue; // Torna all'inizio del ciclo
            }

            // Se ho un metodo scelto, lo passo al gestore per elaborare il pagamento
            if (metodoScelto != null) {
                gestorePagamenti.elabora(metodoScelto, importo);
            }
        }

        scanner.close();
    }
}

