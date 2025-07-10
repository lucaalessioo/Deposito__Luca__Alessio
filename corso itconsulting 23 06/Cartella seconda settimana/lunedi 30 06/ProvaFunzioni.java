class UtilitaMatematica {

   static int quadrato(int num) { //metodo statico
       return num * num;
   }
   int cubo(int num) {
       return num * num * num ;
   }
}

public class ProvaFunzioni {
    
    public static void main(String[] args) {
        
       /*  int risultato = (fattoriale(5));
        System.out.println(risultato);
    }
    static int fattoriale(int n) {
        if(n==1) {
            return 1;
        }
        return n * fattoriale(n-1);
    }*/
    
    System.out.println(UtilitaMatematica.quadrato(5));  // nessun oggetto necessario
    UtilitaMatematica obj = new UtilitaMatematica();
    System.out.println(obj.cubo(5));   // Oggetto nescessario

    }
    
}
