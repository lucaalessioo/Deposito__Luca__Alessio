import java.util.ArrayList;

public class EsercizioEreditarietaAnimali {
    public static void main(String[] args) {

        ArrayList<Animale> listaAnimali = new ArrayList<>();

        Cane cane = new Cane("Fuffy" , 18);
        Gatto gatto = new Gatto("Miele" , 12);
        Animale animale = new Animale("Generico" , 20);

        listaAnimali.add(cane);
        listaAnimali.add(gatto);
        listaAnimali.add(animale);

        for(Animale animale1 : listaAnimali) {
            animale1.stampaDettagli();
            System.out.print("Il suo verso è: ");
             animale1.faiVerso();
        }
    }
}

class Animale {
    // Variabili d istanza
    String nome ;
    int eta;

    
    public Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }


    public void stampaDettagli() {
        System.out.println("Il nome dell animale è: "+ nome + " - L eta è : "+ eta);
    }


    // Metodo del padre
    public void faiVerso() {
        System.out.println("Verso Generico!");
    }
}

class Cane extends Animale {

     // Costruttore che richiama quello del padre
    public Cane(String nome, int eta) {
        super(nome, eta);
    }

    // Metodo del figlio
    public void faiVerso() {
        System.out.println("Bau");
    }

    public void stampaDettagli() {
        System.out.println("Il nome dell cane è: "+ nome + " - L eta è : "+ eta);
    }

}

class Gatto extends Animale {

    // Costruttore che richiama quello del padre
    public Gatto(String nome, int eta) {
        super(nome, eta);
       
    }

    
    public void stampaDettagli() {
        System.out.println("Il nome dell gatto è: "+ nome + " - L eta è : "+ eta);
    }

    // Metodo del figlio
    public void faiVerso() {
        System.out.println("Miao");
    }
}
