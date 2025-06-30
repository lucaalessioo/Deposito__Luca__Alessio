class Auto {
    String marca;
    int anno;
    double prezzo;

    void mostraInfo() {
        System.out.println("Marca: " +marca + " - Anno: " + anno + " - Euro: " + prezzo);
    }
}

public class EsempioClassi {
    public static void  main(String[] args) {
        
        Auto auto = new Auto();
        auto.marca = "Audi" ; 
        auto.anno = 1900;
        auto.prezzo = 1500.500;
        auto.mostraInfo();

    }   
}
