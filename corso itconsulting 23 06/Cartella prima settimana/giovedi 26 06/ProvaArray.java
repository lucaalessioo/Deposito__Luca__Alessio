public class ProvaArray {
    public static void main(String[] args) {
    // Dichiarazione e inizializzazione
 
    int[] numeri = new int[5];   // Array di dimensione 5
   
    int[] valori = {1, 2, 3, 4, 5};  // Inizializzazione diretta
        
    int[] numeri2 = {10, 20, 30, 40, 50};

    System.out.println("Primo numero: " + numeri2[0]);
    
    // for per riempire l arrai e stamparlo
    for(int i = 1 ; i <= numeri.length ; i++) {
        numeri[0] = i+1;
        System.out.println(i);
    }

    // Inizializzazione indiretta
    int[][] matrice = new int[5][5];

    // Inizializzazione diretta
 int[][] matricePredefinita = { {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
         };
        System.out.println("Elemento centrale: " + matrice[1][1]);


int[][] matrice2 = new int[3][3]; // Dichiarazione di una matrice 3x3
 int valore = 1;
 // Riempimento della matrice con numeri progressivi
 for (int i = 0; i < matrice2.length; i++) {
 for (int j = 0; j < matrice2[i].length; j++) {
 matrice2[i][j] = valore++;
 }
 }
 // Stampa della matrice
 System.out.println("Matrice 3x3:");
 for (int i = 0; i < matrice2.length; i++) {
 for (int j = 0; j < matrice2[i].length; j++) {
 System.out.print(matrice2[i][j] + "\t");
 }
 System.out.println(); // Nuova riga per formattare la matrice
 }
   

}
}
