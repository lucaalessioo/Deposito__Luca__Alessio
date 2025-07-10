public class EsercizioFacileAdapter {
    public static void main(String[] args) {

        // Abbiamo una presa americana (il nostro Adaptee)
        AmericanSocket americanSocket = new AmericanSocket();
        System.out.println("Spina americana (Serve un adattatore)");

      
        EuropeanSocket europeanAdapter = new SocketAdapter(americanSocket);    // Creo una istanza dell adattatore e gli passo il dispositivo da adattare e lo assegno al tipo dell interfaccia (Target)
        System.out.println("Qui trasformo la spina in europea");


        // Colleghiamo l'adattatore al muro europeo (il Client usa l'interfaccia Target).
        System.out.println("\n Provo a collegare il dispositivo...");
        europeanAdapter.giveElectricity();                                                  // Chiamo il metodo dell adattatore per adaattare la spina 
        System.out.println(" Dispositivo collegato con successo!");
    }
}

// Metodo da usare nel codice legacy
interface EuropeanSocket {
    void giveElectricity();
}

// Classe da adattare 
class AmericanSocket {
    public void provideElectricity() {
        System.out.println("Serve la presa americana");
    }
}

// Adattatore
class SocketAdapter implements EuropeanSocket {

    private AmericanSocket americanSocket;     // Instanza dell oggetto da adattare

    public SocketAdapter(AmericanSocket americanSocket) {      // Nel costruttore dell adattatore gli passo come parametro l oggetto legacy cosi da poterlo utilizzare per chiamare provideElectricity
        this.americanSocket = americanSocket;
    }

    @Override
    public void giveElectricity() {
        System.out.println("Adattatore europeo");
        americanSocket.provideElectricity();
        System.out.println("Sei riuscito ad adattare la presa. Complimenti!!");
    }

}

