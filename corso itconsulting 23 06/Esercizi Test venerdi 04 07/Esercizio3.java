import java.util.Scanner;

// Classe base
abstract class Cadetto {
    protected String nome;  // variabile protected per vederla anche nelle altre classi che la estendono

    public Cadetto(String nome) {
        this.nome = nome;
    }

    // Metodo astratto, da implementare nelle classi figlie
    public abstract void stampaMessaggio();
}

// Prima classe figlia
class CadettoMarinaio extends Cadetto {
    private String marePreferito; // Parametro unico

    public CadettoMarinaio(String nome, String marePreferito) {
        super(nome);
        this.marePreferito = marePreferito;
    }

    // Messaggio personalizzato
    @Override
    public void stampaMessaggio() {
        System.out.println(nome + " è un Marinaio, il mare che preferisce è: " + marePreferito);
    }
}

// Seconda classe figlia
class CadettoSoldato extends Cadetto {
    private String armaPreferita; // Parametro unico

    public CadettoSoldato(String nome, String armaPreferita) {
        super(nome);
        this.armaPreferita = armaPreferita;
    }

    @Override
    public void stampaMessaggio() {
        System.out.println(nome + " è un Soldato, la sua arma preferita è: " + armaPreferita);
    }
}

// Terza classe figlia
class CadettoPilota extends Cadetto {
    private String aereoPreferito; // Parametro unico

    public CadettoPilota(String nome, String aereoPreferito) {
        super(nome);
        this.aereoPreferito = aereoPreferito;
    }

    @Override
    public void stampaMessaggio() {
        System.out.println(nome + " è un Pilota, il suo aereo preferito è: " + aereoPreferito);
    }
}

// Classe principale
public class Esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi all'utente il nome
        System.out.print("Inserisci il nome del cadetto: ");
        String nome = scanner.nextLine();

        // Chiedi all'utente di scegliere una tipologia di cadetto
        System.out.println("Scegli il tipo di cadetto:");
        System.out.println("1. Marinaio");
        System.out.println("2. Soldato");
        System.out.println("3. Pilota");
        System.out.print("Inserisci un numero (1-3): ");
        int scelta = scanner.nextInt();
        scanner.nextLine();  // Consuma la newline

        // Crea il cadetto in base alla scelta
        Cadetto cadetto = null;
        switch (scelta) {
            case 1:
                System.out.print("Inserisci il mare preferito: ");
                String mare = scanner.nextLine();
                cadetto = new CadettoMarinaio(nome, mare);
                break;
            case 2:
                System.out.print("Inserisci l'arma preferita: ");
                String arma = scanner.nextLine();
                cadetto = new CadettoSoldato(nome, arma);
                break;
            case 3:
                System.out.print("Inserisci l'aereo preferito: ");
                String aereo = scanner.nextLine();
                cadetto = new CadettoPilota(nome, aereo);
                break;
            default:
                System.out.println("Scelta non valida.");
                break;
        }

        // Stampa il messaggio relativo al tipo di cadetto
        if (cadetto != null) {
            cadetto.stampaMessaggio();
        }

        scanner.close();
    }
}
