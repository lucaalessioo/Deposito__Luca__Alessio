import java.util.ArrayList;
import java.util.List;

// Sogetto
public class AgenziaBorsa {                                                
    private List<Investitore> listaInvestitori = new ArrayList<>();     // Lista di Observer

    public void aggiungiInvestitore(Investitore i) {
        listaInvestitori.add(i);
    }

    public void rimuoviInvestitore(Investitore i) {
        listaInvestitori.remove(i);
    }

     // Metodo che notifica tutti gli investitori del cambiamento di un'azione
    public void notificaInvestitori(String nome, double valore) {
        for (Investitore i : listaInvestitori) {
            i.notifica(nome, valore);
        }
    }

    // Metodo chiamato quando cambia il valore di un'azione
    public void aggiornaValoreAzione(String nome, double valore) {
        System.out.println("\n[Aggiornamento azione " + nome + "]");
        notificaInvestitori(nome, valore);
    }
}

// Observer
interface Investitore {

    void notifica(String azione , double valore);
    
}

//Observer
class InvestitorePrivato implements Investitore {
    
    private String nome;

    public InvestitorePrivato(String nome) {
        this.nome = nome;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println(nome + ": Notifica: " + azione + " valore " + valore + " Euro");
    }

}

// Singleton
class InvestitoreBancario implements Investitore {
    private static InvestitoreBancario istanza;        // Istanza privata e statica della classe 
    private String banca;                              // Nome della banca

    private InvestitoreBancario(String banca) {        // Costruttore privato
        this.banca = banca;
    }

    // Metodo per avere una sola istanza di Investitore Bancario
    public static InvestitoreBancario getIstanza(String banca) {
        if (istanza == null) {
            istanza = new InvestitoreBancario(banca);
        }
        return istanza;
    }

    // Metodo dell interfaccia
    @Override
    public void notifica(String azione, double valore) {
        System.out.println(banca + ". Aggiornamento banca: " + azione + " = " + valore + " Euro");
    }
}


