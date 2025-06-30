import java.util.ArrayList;

public class ApplicationCalcolatrice {
    public static void main(String[] args) {
        
        Calcolatrice calcolatrice = new Calcolatrice();
        calcolatrice.saluta();
        
        int risultato = calcolatrice.somma(10, 5);
        System.out.println(risultato);

        ArrayList<Auto> autoList = new ArrayList<>();
        autoList.add(new Auto("Tesla", 2023));
        autoList.add(new Auto("Ford", 2020));
        for (Auto auto : autoList) {
        System.out.println(auto.marca + " - " + auto.anno);
        }
    }
}

class Calcolatrice {
    // Metodo con ritorno
    int somma(int a, int b) {
        return a+b;
    }

    void saluta() {
        System.out.println("Ciao");
    }
}

class Auto {
    String marca;
    int anno;

    Auto(String marca , int anno) {
        this.marca = marca;
        this.anno = anno;
    }

}