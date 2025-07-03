public class EsercizioPolimorfismo {
    public static void main(String[] args) {
        // Due oggetti Persona
        Persona p1 = new Persona("Marco");
        Persona p2 = new Persona("Lucia");
        // Chiamata al metodo saluta della persona
        p1.saluta();  
        p2.saluta();  
        // Oggetto Pirata
        Pirata pirata = new Pirata("Barbanera");
        pirata.saluta();  // Metodo del pirata
    }
}

class Persona {
    
    private String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void saluta() {
        System.out.println("Ciao sono una persona...");
    }
}


// Classe derivata Pirata
class Pirata extends Persona {

    // Costruttore: chiama quello della classe base
    public Pirata(String nome) {
        super(nome);
    }

    // Override del metodo saluta
    @Override
    public void saluta() {
        System.out.println("Ciao Sono un pirata...");
    }
}
