// Programma principale
public class Application {
    public static void main(String[] args) {
        // Creazione di oggetti Auto e Moto
        Veicolo auto = new Auto("Fiat", "Panda", 2022, 5);
        Veicolo moto = new Moto("Yamaha", "MT-07", 2021, "Sportivo");

        // Utilizzo del metodo dinamico per stampare le informazioni
        System.out.println(auto.informazioniVeicolo());
        System.out.println(moto.informazioniVeicolo());
    }
}

// Classe base Veicolo
abstract class Veicolo {
    // Attributi comuni
    private String marca;
    private String modello;
    private int anno;

    // Costruttore
    public Veicolo(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    // Metodo per stampare informazioni generali da implementare nelle sotto classi
    public abstract String informazioniVeicolo();

    // Getter 
    public String getMarca() {
         return marca; 
        }
    public String getModello() {
         return modello; 
        }
    public int getAnno() {
         return anno; 
        }
}

// Classe Auto che estende Veicolo
class Auto extends Veicolo {
    // Attributo specifico per Auto
    private int numeroPorte;

    // Costruttore Auto
    public Auto(String marca, String modello, int anno, int numeroPorte) {
        super(marca, modello, anno);
        this.numeroPorte = numeroPorte;
    }

    // toString
    @Override
    public String informazioniVeicolo() {
        return "Auto [Marca=" + getMarca() + ", Modello=" + getModello() + ", Anno=" + getAnno() + ", Numero Porte=" + numeroPorte + "]";
    }
}

// Classe Moto che estende Veicolo
class Moto extends Veicolo {
    // Attributo specifico per Moto
    private String tipoManubrio;

    // Costruttore Moto
    public Moto(String marca, String modello, int anno, String tipoManubrio) {
        super(marca, modello, anno);
        this.tipoManubrio = tipoManubrio;
    }

    // toString
    @Override
    public String informazioniVeicolo() {
        return "Moto [Marca=" + getMarca() + ", Modello=" + getModello() + ", Anno=" + getAnno() + ", Tipo Manubrio=" + tipoManubrio + "]";
    }
}

