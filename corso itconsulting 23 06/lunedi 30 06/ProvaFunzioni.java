public class ProvaFunzioni {

    public static void main(String[] args) {
        
       int risultato = (fattoriale(5));
        System.out.println(risultato);
    }
     static int fattoriale(int n) {
        if(n==1) {
            return 1;
        }
        return n * fattoriale(n-1);
    }

    
}
