import java.util.Scanner;

// Interfaccia base per il testo Decorator
interface TestoComponente {
    String getContenuto();
}

// Implementazione del testo semplice
class TestoSemplice implements TestoComponente {
    private String contenuto;
    public TestoSemplice(String contenuto) { 
        this.contenuto = contenuto; 
    }
    @Override 
    public String getContenuto() {
         return contenuto; 
        }
}

// Base astratta per i Decorator del testo
abstract class TestoDecorator implements TestoComponente {
    protected TestoComponente testoDecorato; // Variabile del tipo dell interfaccia del decorator 

    public TestoDecorator(TestoComponente testoDecorato) {
         this.testoDecorato = testoDecorato; 
        }
    @Override
    public String getContenuto() {              // Testo decorato piu il testo normale
         return testoDecorato.getContenuto(); 
        }
}

// Decoratore per il Grassetto 
class GrassettoDecorator extends TestoDecorator {
    public GrassettoDecorator(TestoComponente testoDecorato) {
         super(testoDecorato); 
        }
    @Override 
    public String getContenuto() {
         return "**" + super.getContenuto() + "**";    // Simulazione grassetto
        }
}

// Decoratore per il Corsivo 
class CorsivoDecorator extends TestoDecorator {
    public CorsivoDecorator(TestoComponente testoDecorato) {
         super(testoDecorato); 
        }
    @Override 
    public String getContenuto() {
         return "_" + super.getContenuto() + "_";  // Simulazione del testo in corsivo
        }
}

// Interfaccia per le Strategie di Salvataggio
interface StrategiaSalvataggio {
    void salva(String nomeFile, String contenuto);  // Prendiamo il nome del file e il contenuto
}

// Strategia: Salvataggio Locale
class SalvataggioLocale implements StrategiaSalvataggio {
    @Override
    public void salva(String nomeFile, String contenuto) {
        System.out.println("Salvataggio LOCALE: " + nomeFile);
        System.out.println("Contenuto: " + contenuto);
    }
}

// Strategia: Salvataggio Cloud
class SalvataggioCloud implements StrategiaSalvataggio {
    @Override
    public void salva(String nomeFile, String contenuto) {
        System.out.println("Salvataggio CLOUD: '" + nomeFile + "'");
        System.out.println("Invio: " + contenuto);
        System.out.println("Salvataggio cloud completato.");
    }
}

// L'Editor di Testo che usa i pattern
class EditorDiTesto {
    private TestoComponente testoCorrente;
    private StrategiaSalvataggio strategiaSalvataggioCorrente;

    public EditorDiTesto(String testoIniziale) {
        this.testoCorrente = new TestoSemplice(testoIniziale);
        this.strategiaSalvataggioCorrente = new SalvataggioLocale(); // Default
        System.out.println("Editor pronto. Testo: " + testoIniziale);
    }

    // Applico il formato ritornando l oggetto in base al formato
    public void applicaFormato(String tipoFormato) {
        switch (tipoFormato.toLowerCase()) { 
            case "grassetto": testoCorrente = new GrassettoDecorator(testoCorrente);
                     break;
            case "corsivo": testoCorrente = new CorsivoDecorator(testoCorrente);
                     break;
            default: System.out.println("Formato sconosciuto: " + tipoFormato);
                     return;
        }
        System.out.println("Formato applicato: " + tipoFormato);
    }

    // Metodo per settare la strategia
    public void setStrategiaSalvataggio(StrategiaSalvataggio nuovaStrategia) {
        this.strategiaSalvataggioCorrente = nuovaStrategia;
       
    }

    public void salvaTesto(String nomeFile) {
        if (strategiaSalvataggioCorrente != null) {
            System.out.println("\nAvvio salvataggio");
            strategiaSalvataggioCorrente.salva(nomeFile, testoCorrente.getContenuto());
        } else {
            System.out.println("Errore: Nessuna strategia di salvataggio!");
        }
    }

    // Semplice metodo per la stampa del testo finale
    public void mostraTesto() {
        System.out.println("\nTesto Finale");
        System.out.println(testoCorrente.getContenuto());
        System.out.println("--------------------");
    }
}



// Classe principale per l'esecuzione
public class Esercizio7 {
    public static void main(String[] args) {
        // Inizializzazione editor con un testo di esempio
        EditorDiTesto mioEditor = new EditorDiTesto("Messaggio.");

        // Applicazione di formati multipli
        mioEditor.applicaFormato("grassetto");
        mioEditor.applicaFormato("corsivo");
        mioEditor.mostraTesto();

        // Cambio strategia e salvataggio
        mioEditor.setStrategiaSalvataggio(new SalvataggioCloud());
        mioEditor.salvaTesto("immaggine salvata sul cloud");

        // Ritorno al salvataggio locale per un ultimo test
        mioEditor.setStrategiaSalvataggio(new SalvataggioLocale());
        mioEditor.salvaTesto("salvataggio finale");
    }
}