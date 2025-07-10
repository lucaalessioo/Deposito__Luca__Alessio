public class ApplicationObserver {
    public static void main(String[] args) {
        
        StazioneMeteo stazione = new StazioneMeteo();

        Display d1 = new DisplayConsole();
        Display d2 = new DisplayMobile();

        stazione.aggiungiDisplay(d1);
        stazione.aggiungiDisplay(d2);

        stazione.setTemperatura(25.0f);
        stazione.setTemperatura(30.5f);
    }
}
