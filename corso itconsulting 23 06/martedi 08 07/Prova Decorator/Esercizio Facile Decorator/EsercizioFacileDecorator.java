public class EsercizioFacileDecorator {
    public static void main(String[] args) {
        Messaggio messaggioSemplice = new MessaggioBase();
        Messaggio messaggioMaiuscolo = new DecoratoreMaiuscolo(messaggioSemplice);

        System.out.println("Messaggio originale: " + messaggioSemplice.getContenuto());
        System.out.println("Messaggio decorato: " + messaggioMaiuscolo.getContenuto());
    }
}


