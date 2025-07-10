import java.util.ArrayList;
import java.util.List;

// Interfaccia per la Strategy
interface MetodoDiPagamento {
    void paga(double importo);
    String getNome();
}

// Metodo per notificare
interface AvvisatorePagamento {
    void pagamentoAvvenuto(double importo, String metodo, boolean successo);
}

// Context
class PagamentoContext {
    private MetodoDiPagamento metodoAttuale; // Qui salvo il metodo scelto

    public void impostaMetodo(MetodoDiPagamento metodo) {
        this.metodoAttuale = metodo; // "setto il metodo di pagamento"
    }

    public void eseguiPagamento(double importo) {
        if (metodoAttuale != null) {     // Se ho scelto un metodo allora eseguo paga
            metodoAttuale.paga(importo); // Chiede al metodo scelto di fare il suo lavoro
        } else {
            System.out.println("Nessun metodo di pagamento impostato!");
        }
    }
}
//-------------------------------------------------------------------------------------------------------------------------

// Classe singleton con observer che gestisce i pagamenti
class GestorePagamenti {
    private static GestorePagamenti unicaIstanza; // unica istanza
    private List<AvvisatorePagamento> chiDeveEssereAvvisato = new ArrayList<>(); // osservatori

    
    private GestorePagamenti() {

    }

    // Metodo per avere una sola istanza 
    public static GestorePagamenti getIstanza() {
        if (unicaIstanza == null) {
            unicaIstanza = new GestorePagamenti();
        }
        return unicaIstanza;
    }

    // Metodo principale per elaborare un pagamento
    public void elabora(MetodoDiPagamento metodo, double importo) {
        System.out.println("\nPagamento");
        PagamentoContext contesto = new PagamentoContext(); 
        contesto.impostaMetodo(metodo); // setto il metodo di pagamento

        boolean successo = false; // Controlla se il pagamento è andato a buon fine
        try {
            contesto.eseguiPagamento(importo); // Il terminale esegue il pagamento
            successo = true; // pagamento riuscito
            System.out.println("Pagamento riuscito!");
        } catch (Exception e) {
            System.out.println("Errore nel pagamento: " + e.getMessage());
        } finally {
            // Avviso tutti (Observer)
            avvisaChiDiDovere(importo, metodo.getNome(), successo);
        }
        System.out.println("Fine Pagamento\n");
    }

    // Metodi per aggiungere/rimuovere gli osservatori
    public void aggiungiOsservatore(AvvisatorePagamento avvisatore) {
        chiDeveEssereAvvisato.add(avvisatore);
    }
    public void rimuoviOsservatore(AvvisatorePagamento avvisatore) {
        chiDeveEssereAvvisato.remove(avvisatore);
    }
    // Avvisa tutti nella lista
    private void avvisaChiDiDovere(double importo, String metodoNome, boolean successo) {
    for (AvvisatorePagamento avvisatore : chiDeveEssereAvvisato) {
        avvisatore.pagamentoAvvenuto(importo, metodoNome, successo);
    }
}
}

// Classe per la stampa del log
class LogDiPagamento implements AvvisatorePagamento {
    @Override
    public void pagamentoAvvenuto(double importo, String metodo, boolean successo) {
        String stato = successo ? "RIUSCITO" : "FALLITO";  // 
        System.out.println("[LOG] Il pagamento di " + importo + "Euro con " + metodo + " è stato: " + stato);
    }
}

// Classe per la stampa per l utente
class ConfermaUtente implements AvvisatorePagamento {
    @Override
    public void pagamentoAvvenuto(double importo, String metodo, boolean successo) {
        if (successo) {
            System.out.println("[AVVISO UTENTE] Pagamento di " + importo + "Euro con " + metodo + " confermato. Grazie!");
        } else {
            System.out.println("[AVVISO UTENTE] Attenzione: problema con il pagamento di " + importo + "Euro con " + metodo + ". Riprova.");
        }
    }
}


class CartaDiCredito implements MetodoDiPagamento {
    @Override
    public void paga(double importo) {
        System.out.println("Sto pagando con la Carta di Credito: " + importo + "€");
    }
    @Override
    public String getNome() { 
        return "Carta di Credito";  // Stampa specifica per la carta di credito
    }
}

class PayPal implements MetodoDiPagamento {
    @Override
    public void paga(double importo) {
        System.out.println("Sto pagando con PayPal: " + importo + "€");
    }
    @Override
    public String getNome() { // Stampa specifica del paypal
        return "PayPal"; 
    }
}
