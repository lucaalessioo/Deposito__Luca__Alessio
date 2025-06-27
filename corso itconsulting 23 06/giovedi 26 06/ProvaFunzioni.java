public class ProvaFunzioni {
    public static void main(String[] args) {

        mostra(10);       
   
        // Chiama mostra(int)
        mostra("Ciao");  // Chiama mostra(String)

        saluta();

        int a = 10;
        int b = 5;

        int risultato =somma(a, b);
        System.out.println(risultato);
    }
    static void saluta() {
        System.out.println("Ciao");
    }
    static int somma(int a, int b) {
        return a+b;
    }
    static void mostra(int numero) {   
    System.out.println("Numero: " + 10 + numero);
    }
    
    static void mostra(String testo) {
        
    System.out.println("Testo: " + testo);
    }
}



 
