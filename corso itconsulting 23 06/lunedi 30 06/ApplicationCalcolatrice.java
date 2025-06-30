
public class ApplicationCalcolatrice {
    public static void main(String[] args) {
        
        Calcolatrice calcolatrice = new Calcolatrice();
        calcolatrice.saluta();
        
        int risultato = calcolatrice.somma(10, 5);
        System.out.println(risultato);
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