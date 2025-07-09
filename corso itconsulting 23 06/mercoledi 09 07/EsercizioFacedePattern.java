public class EsercizioFacedePattern {
    public static void main(String[] args) {
        GestoreLuciFacede gestoreLuciFacede = new GestoreLuciFacede();

        gestoreLuciFacede.accendiTutte(); // Accendo entrambe le luci
    }
}
// Classe specifica
class LuceCamera {
    public void accendiCamera() {
        System.out.println("Luca Camera accesa!");
    }
}

// Classe specifica
class LuceCucina {
    public void accendiCucina() {
        System.out.println("Luca Cucina accessa!");
    }
}

// Facede
class GestoreLuciFacede {
    private LuceCamera luceCamera = new LuceCamera();
    private LuceCucina luceCucina = new LuceCucina();

    public void accendiTutte() {
        luceCamera.accendiCamera();
        luceCucina.accendiCucina();
    }
}
