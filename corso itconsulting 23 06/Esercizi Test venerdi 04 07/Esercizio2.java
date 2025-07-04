public class Esercizio2 {
    public static void main(String[] args) {
        // Creazione di un oggetto ContoBancario
        ContoBancario conto1 = new ContoBancario("123456789", "Mario Rossi");

        // Eseguiamo alcune operazioni su conto1
        conto1.deposita(500);  
        conto1.preleva(200);   
        conto1.deposita(300);  

        // Mostra il saldo finale
        conto1.mostraSaldo();
    }
}

// Classe ContoBancario
class ContoBancario {
    // Variabili  d istanza
    private String numeroConto;
    private double saldo;
    private String user;

    // Costruttore
    public ContoBancario(String numeroConto, String user) {
        this.numeroConto = numeroConto;
        this.saldo = 0.0;                               // saldo iniziale
        this.user = user;
    }

    // Getter e Setter 
    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    
    public double getSaldo() {
        return saldo;
    }

   
    public String getTitolare() {
        return user;
    }

    // Metodo per depositare fondi
    public void deposita(double importo) {
        if (importo > 0) {                                                          // Se importo maggiore di 0 allora fai il deposito altrimenti importo non valido
            saldo += importo;
            System.out.println("Deposito effettuato: " + importo);
        } else {
            System.out.println("Importo non valido per il deposito.");
        }
    }

    // Metodo per prelevare fondi
    public void preleva(double importo) {
        if (importo > 0 && importo <= saldo) {                                      // Se importo è maggiore di 0 e minore o uguale al saldo allora fai operazione
            saldo -= importo;
            System.out.println("Prelievo effettuato: " + importo);
        } else if (importo > saldo) {                                               // se solo maggiore del saldo vai in errore
            System.out.println("Errore: saldo insufficiente per il prelievo.");
        } else {
            System.out.println("Importo non valido per il prelievo.");
        }
    }

    // Metodo per visualizzare il saldo finale
    public void mostraSaldo() {
        System.out.println("Saldo attuale: " + saldo);
    }
}
