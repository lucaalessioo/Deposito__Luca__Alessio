// Interfaccia Obiettivo (Target)
// Quello che il nostro codice si aspetta di usare.
interface Utente {
    void faiAzione();
}

// Servizio Esistente (Adaptee)
// Un componente che funziona, ma ha un'interfaccia diversa.
class ServizioVecchio {
    void eseguiCompitoSpecifico() {
        System.out.println("Servizio vecchio: Ho eseguito un compito specifico.");
    }
}

// Adattatore (Adapter)
// Rende il ServizioVecchio compatibile con l'interfaccia Utente.
class AdattatoreServizio implements Utente {
    private ServizioVecchio vecchioServizio; // Riferimento al servizio che si vuole adattare

    public AdattatoreServizio(ServizioVecchio vecchioServizio) {
        this.vecchioServizio = vecchioServizio;
    }

    // Implementa l'interfaccia Utente, ma usa il ServizioVecchio.
    @Override
    public void faiAzione() {
        System.out.println("Adattatore: Traduco l'azione per il vecchio servizio...");
        vecchioServizio.eseguiCompitoSpecifico(); // Chiama il metodo del servizio incompatibile
        System.out.println("Adattatore: Azione completata.");
    }
}

// Programma Principale (Client)
// Il codice che usa l'interfaccia Utente.
class ProgrammaClient {
    public static void main(String[] args) {
        // 1. Abbiamo un servizio che non si adatta direttamente (l'Adaptee).
        ServizioVecchio servizioIncompatibile = new ServizioVecchio();

        // 2. Creiamo l'Adattatore, collegandolo al servizio incompatibile.
        // Ora l'Adattatore si presenta come un "Utente".
        Utente utenteCompatibile = new AdattatoreServizio(servizioIncompatibile);

        // 3. Il ProgrammaClient usa l'Adattatore come se fosse un normale "Utente".
        System.out.println("Programma Client: Richiedo un'azione...");
        utenteCompatibile.faiAzione(); // Il client chiama "faiAzione", l'adattatore si occupa del resto!
        System.out.println("Programma Client: Richiesta gestita.");
    }
}
