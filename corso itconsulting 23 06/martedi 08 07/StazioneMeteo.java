import java.util.ArrayList;
import java.util.List;

public class StazioneMeteo {                                    // Subject
    private List<Display> displays = new ArrayList<>();
    private float temperatura;
    
    public void aggiungiDisplay(Display d) {                    // Aggiungo un display alla lista di display
        displays.add(d);
    }
    
    public void rimuoviDisplay(Display d) {                     // Rimuovo un display dalla lista di display
        displays.remove(d);
    }

    public void setTemperatura(float t) {                       // Ogni volta che cambio la temperatura notifico le classi concrete
        this.temperatura = t;
        notificaDisplay();
    }
    
    
    private void notificaDisplay() {                            // Metodo per notificare
        for (Display d : displays) {                            // Ciclo la lista
            d.aggiorna(temperatura);                            // Chiamo il metodo aggiorna su ogni elemento
        }
    }
}

// Observer
interface Display {
   void aggiorna(float temperatura);
}

// Classe concreta che implementa display
class DisplayMobile implements Display {

    @Override
    public void aggiorna(float temperatura) {
        System.out.println("[Mobile] Notifica: nuova temperatura = " + temperatura + "°C");
    }
}

// Classe concreta che implementa display
class DisplayConsole implements Display {

    @Override
    public void aggiorna(float temperatura) {
        System.out.println("[Console] Temperatura aggiornata: " + temperatura + "°C");
    }
}



