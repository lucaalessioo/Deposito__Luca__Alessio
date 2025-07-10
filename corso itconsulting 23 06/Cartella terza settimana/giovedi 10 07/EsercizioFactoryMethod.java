import java.util.Scanner;

public class EsercizioFactoryMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VeicoloFactory factory = null; // Dichiarazione della factory generica
        String tipoVeicolo; // Variabile per l'input dell'utente

        // Il loop continuerà finché l'utente non digita "fine"
        do {
            System.out.println("Quale veicolo vuoi creare? (auto, moto, camion) oppure digita 'fine' per uscire:");
            tipoVeicolo = scanner.nextLine().toLowerCase(); 

            // Controlla se l'utente vuole uscire PRIMA di elaborare il tipo di veicolo
            if (tipoVeicolo.equals("fine")) {
                System.out.println("Uscita dal programma.");
                break; // Esce dal loop immediatamente
            }

            // In base all'input dell'utente, creiamo la fabbrica di auto concreta appropriata
            switch (tipoVeicolo) {
                case "auto":
                    factory = new AutoFactory();
                    break;
                case "moto":
                    factory = new MotoFactory();
                    break;
                case "camion":
                    factory = new CamionFactory();
                    break;
                default:
                    System.out.println("Tipo di veicolo non valido. Riprova.");
                    factory = null; // Resetta factory a null per non usare un'istanza precedente valida
                    break;
            }

            // Se factory è diverso da null quindi se è stato creato allora chiama la preparaConsegna
            if (factory != null) {
                factory.preparaConsegna();
            }

        } while (true); // Loop infinito che uscirà solo con il 'break' sopra se si scrive fine

        scanner.close();
    }
}

// Interfaccia da cui prendere i metodi delle classi concrete
interface IVeicolo {
    void avvia();
    void mostraTipo();
}

// Classe concreta Auto implementazione dei metodi
class Auto implements IVeicolo {
   
    @Override
    public void avvia() {
        System.out.println("Avvia Auto!");
    }
    @Override
    public void mostraTipo() {
        System.out.println("Sono del tipo Auto");
    }

   
}

// Classe concreta Moto con implementazione specifica dei metodi
class Moto implements IVeicolo {

    @Override
    public void avvia() {
        System.out.println("Avvia Moto!");
    }

    @Override
    public void mostraTipo() {
       System.out.println("Sono del tipo Moto");
    }

}

// Classe concreta camion con implementazione metodi 
class Camion implements IVeicolo{

    @Override
    public void avvia() {
        System.out.println("Avvia Camion!");
    }

    @Override
    public void mostraTipo() {
        System.out.println("Sono del tipo Camion");
    }

}

// Classe astratta con il metodo factory per la decisione sulla creazione degli ogetti
abstract class VeicoloFactory {
    
    public abstract IVeicolo creaVeicolo(); // Metodo Factory

    // Utilizzo dei metodo senza sapere il tipo concreto
    public void preparaConsegna() {
        IVeicolo veicolo = creaVeicolo(); // Il Factory Method ti ritorna l oggetto veicolo su cui poi chiamo avvia e mostraTipo
        System.out.println("\nPreparazione per la consegna di un veicolo");
        veicolo.avvia();
        veicolo.mostraTipo();
        System.out.println(" -------------------- ");
        System.out.println(" Consegna completata ");
    }
}

// queste classi implementano il Factory Method per creare prodotti specifici
class AutoFactory extends VeicoloFactory {
    @Override
    public IVeicolo creaVeicolo() {
        return new Auto();
    }
}

class MotoFactory extends VeicoloFactory {
    @Override
    public IVeicolo creaVeicolo() {
        return new Moto();
    }
}

class CamionFactory extends VeicoloFactory {
    @Override
    public IVeicolo creaVeicolo() {
        return new Camion();
    }
}

