class Auto {

    // Variabili della classe auto
    String marca;
    int anno;
    double prezzo;

    // metodo per stampare i valori dell oggetto
    void mostraInfo() {
        System.out.println("Marca: " +marca + " - Anno: " + anno + " - Euro: " + prezzo);
    }
}

class Studente {
    String nome ;            // Variabile d istanza 
    static int totaleStudenti = 0 ; // Variabile statica della classe 

    Studente(String nome) {
        this.nome = nome;
        totaleStudenti++;   // incremento per ogni ogetto studente creato
    }
}

public class EsempioClassi {
    public static void  main(String[] args) {

        Studente luca = new Studente("luca");
        Studente marco = new Studente("marco"); 
        System.out.println("Prova variabile statica per il conteggio degli studenti: ");
        System.out.println("Totale studenti creati : " + Studente.totaleStudenti);
        System.out.println();
        System.out.println("Prova Stampa dettagli auto: ");
        Auto auto = new Auto();
        auto.marca = "Audi" ;       // assegno il valore alla marca
        auto.anno = 1900;           // assegno il valore dell anno 
        auto.prezzo = 1500.500;     // assegno il valore al prezzo
        auto.mostraInfo();          // chiamo il metodo per stampare l oggetto

    }   
}
