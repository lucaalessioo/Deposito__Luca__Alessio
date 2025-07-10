public abstract class Veicolo implements TracciabileInterface {
        private String targa;
        private float caricoMassimo;

        public String getTarga() {
            return targa;
        }
        public void setTarga(String targa) {
            this.targa = targa;
        }
        public float getCaricoMassimo() {
            return caricoMassimo;
        }
        public void setCaricoMassimo(float caricoMassimo) {
            this.caricoMassimo = caricoMassimo;
        }

        // Metodo astratto per la consegna del pacco
        public abstract String consegnaPacco(String destinazione, float pesoPacco);

        // Metodo dell interfaccia
        public abstract void tracciaConsegna(String codiceTracking);
        
        // Stampa info
        public String stampaInfo() {
            return "Targa veicolo: " + targa + "Carico Massimo: " + caricoMassimo + " Kg";
        }

        
}

class Furgone extends Veicolo  {

    @Override
    public void tracciaConsegna(String codiceTracking) {
    System.out.println("Tracking furgone - Codice: " + codiceTracking);
}

     @Override
    public String consegnaPacco(String destinazione, float pesoPacco) {
        // Controllo del carico
        if (pesoPacco > getCaricoMassimo()) {
            System.out.println("Errore: il pacco supera il carico massimo per il Furgone!");
            return null; // Non consegna se il carico è troppo grande
        }

        // Altrimenti, effettua la consegna
        System.out.println("Furgone targato " + getTarga() + " sta consegnando via strada a " + destinazione);
        return destinazione; // Restituisce la destinazione
    }

}

 class Drone extends Veicolo {


    @Override
    public String consegnaPacco(String destinazione, float pesoPacco) {
        // Controllo del carico
        if (pesoPacco > getCaricoMassimo()) {
            System.out.println("Errore: il pacco supera il carico massimo per il Drone!");
            return null; // Non consegna se il carico è troppo grande
        }

        // Altrimenti, effettua la consegna
        System.out.println("Drone targato " + getTarga() + " sta volando verso " + destinazione);
        return destinazione; // Restituisce la destinazione
    }

    @Override
    public void tracciaConsegna(String codiceTracking) {
    System.out.println("Tracking drone - Codice: " + codiceTracking + " tracciamento automatico");
}
}
