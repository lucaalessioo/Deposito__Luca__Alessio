public class ApplicationStrategy {
    public static void main(String[] args) {
  
        // Creiamo un'istanza del nostro Context 
        Calcolatore calcolatore = new Calcolatore();

        // Addizione
        System.out.println("Strategia : Addizione");

        // Imposto la strategia di addizione nel calcolatore
        calcolatore.setOperazione(new Addizione());
        int risultatoAddizione = calcolatore.eseguiOperazione(10, 5); // Eseguo l'operazione. In questo caso Addizione
        System.out.println("Risultato Addizione: " + risultatoAddizione); 

        // Moltiplicazione 
        System.out.println("\nStrategia : Moltiplicazione");
        calcolatore.setOperazione(new Moltiplicazione());
        // Eseguo l'operazione. Moltiplicazione
        int risultatoMoltiplicazione = calcolatore.eseguiOperazione(10, 5);
        System.out.println("Risultato Moltiplicazione: " + risultatoMoltiplicazione); // Output: 50
    }
}

// Interfaccia Strategy
interface Operazione {
    // Metodo da implementari in base a..
    int esegui(int a, int b);
}

// Classe concreta Addizione con il suo tipo di override
class Addizione implements Operazione {
    @Override
    public int esegui(int a, int b) {
        System.out.println("Addizione: " + a + " + " + b);
        return a + b;
    }
}

// Classe concreta Moltiplicazione con il suo tipo specifico di override
class Moltiplicazione implements Operazione {
    @Override
    public int esegui(int a, int b) {
        System.out.println("Moltiplicazione: " + a + " * " + b);
        return a * b;
    }

}

// Context gestisce l'utilizzo delle diverse strategie
class Calcolatore {
    private Operazione operazione; // Riferimento all'interfaccia Strategy

    // Metodo per impostare dinamicamente la strategia
    public void setOperazione(Operazione operazione) {
        this.operazione = operazione;
    }

    // Metodo per eseguire l'operazione, delegando alla strategia corrente
    public int eseguiOperazione(int a, int b) {
        if (operazione == null) {
            System.out.println("Nessuna operazione impostata.");
        }
        return operazione.esegui(a, b);
    }
}
