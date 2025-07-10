public class EsercizioMedioFacede {

    public static void main(String[] args) {
        // Otteniamo l'unica istanza del Facade (grazie al pattern Singleton)
        ComputerFacedeSingleton computer = ComputerFacedeSingleton.getInstance();

        System.out.println("Avvio del PC in modalità normale");
        computer.accendiComputer(); //con un singolo metodo ne richiamo 3 grazie al facede

        // Questo mostra la flessibilità del pattern Strategy.
        System.out.println("\nCambio Strategia in modalita Sicura"); // Imposto una nuova strategia per il Sistema Operativo tramite il Facade.
        computer.impostaStrategyAvvioOS(new StrategiaSicura());

        // Richiamo il metodo di avvio per avviare nuovamente
        computer.accendiComputer();

        
        // Grazie al Singleton, ci verrà restituita la stessa istanza di 'computer'.
        ComputerFacedeSingleton anotherComputerInstance = ComputerFacedeSingleton.getInstance();  // Verifica del pattern Singleton 
        System.out.println("\nVerifica Singleton");
        System.out.println("Le due istanze di SingletonFacadeComputer sono le stesse? " + (computer == anotherComputerInstance)); // se da true è la stessa istanza
        

    }
}

// interfaccia strategy
interface Strategy {
    void eseguiAvvio();
}

// Classi per i componenti con rispettivi metodi specifici 
class BIOS {
    public void inizializza() {
        System.out.println("Inizializzazione del BIOS");
        System.out.println("BIOS inizializzato con successo");
        System.out.println("---------------------------");
    }
}

class HardDisk {
    public String carica(String settoreAvvio) {
        System.out.println("Caricamento HardDisk  " + settoreAvvio + "...");
        return "HardDisck caricato\n -----------------------------";
    }
}

// Classe per impostare la strategia normale
class StrategiaNormale implements Strategy {

    @Override
    public void eseguiAvvio() {
        System.out.println("Caricamento...");
        System.out.println("Avvio normale avvenuto con successo!\n -------------------------------------");
    }

    @Override
    public String toString() { 
        return "Avvio Normale avvenuto con successo\n ---------------------------------";
    }
}

// Classe per impostare il tipo di strategia sicura
class StrategiaSicura implements Strategy {

    @Override
    public void eseguiAvvio() {
        System.out.println("Caricamento...");
        System.out.println("Avvio sicuro avvenuto con successo\n --------------------------");
    }

    @Override
    public String toString() { 
        return "Avvio Sicuro avvenuto con successo\n ---------------------------------";
    }
}

// Sistema operativa ( Context )
class ContextSistemaOperativo {
    private static Strategy strategiaDiAvvio;

    public ContextSistemaOperativo(Strategy strategiaDiAvvio) {
        this.strategiaDiAvvio = strategiaDiAvvio;
    };
    
    // Metodo per avviare il sistema operativo
    public void avvia() {
        System.out.println("SistemaOperativo: Avvio in corso...");
        strategiaDiAvvio.eseguiAvvio();
        System.out.println("SistemaOperativo: Avvio completato.");
    }

    // Metodo per settare la strategia di avvio
    public void setStrategyAvvio(Strategy strategiaDiAvvio) {
        this.strategiaDiAvvio = strategiaDiAvvio;
    }
}
    
    // Classe (Singleton e Facede insieme)
    class ComputerFacedeSingleton {
        // Implementazione dei vari componenti e variabile per la creazione singleton dell oggetto
        private static ComputerFacedeSingleton istanza;
        private BIOS ogettoBios = new BIOS();
        private HardDisk ogettoHardDisk = new HardDisk();
        private StrategiaNormale strategiaNormale = new StrategiaNormale();   // Strategia Hard Codata per lo start impostata su normale
        private ContextSistemaOperativo oggettoSistemaOperativo = new ContextSistemaOperativo(strategiaNormale);

        // Costruttore privato per controllare la creazione di 1 singolo oggetto
        private ComputerFacedeSingleton() {

        }

        // Metodo specifico del singleton per la creazione dell istanza controllata
        public static ComputerFacedeSingleton getInstance() {
            if(istanza == null) {
                istanza = new ComputerFacedeSingleton();
            }
            return istanza;
        }

        // Metodo di avvio accensione gestito dal facede
        public void accendiComputer() {
        System.out.println("\nAccensione del computer");
        ogettoBios.inizializza();  // Inizializzazione del bios
        String infoHardisck = ogettoHardDisk.carica("Avvio Principale HardDisck"); // Avvio dell HardDisck
        System.out.println("Informazioni HardDisck ottenute: " + infoHardisck); // Stampa di conferma
        oggettoSistemaOperativo.avvia();  // Avvio del sistema operativo
        System.out.println("Computer avviato con successo!\n");
    }

    // Setto la strategia
    public void impostaStrategyAvvioOS(Strategy strategy) {
        System.out.println("Strategia di avvio del Sistema Operativo impostata su " + strategy + ".");
        this.oggettoSistemaOperativo.setStrategyAvvio(strategy);
        System.out.println("Strategia di avvio del Sistema Operativo impostata su " + strategy + ".");
    }

    }
