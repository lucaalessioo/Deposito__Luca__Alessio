import java.util.ArrayList;
import java.util.Collections;

public class ProvaArrayList {
        public static void main(String[] args) {
 
 ArrayList<Integer> numeri = new ArrayList<>();
 numeri.add(10);
 numeri.add(20);
 numeri.add(30);

  
ArrayList<Integer> numeri2 = new ArrayList<>();

 // Aggiunta di 10 numeri casuali
 for (int i = 0; i < 10; i++) {
 numeri2.add( (int) (Math.random() * 100) + 1);
 }

 // Stampa della lista originale
 System.out.println("Lista originale: " + numeri2);

 // Ordinamento della lista
 Collections.sort(numeri2);

 // Stampa della lista ordinata
 System.out.println("Lista ordinata: " + numeri2);

    }
}


