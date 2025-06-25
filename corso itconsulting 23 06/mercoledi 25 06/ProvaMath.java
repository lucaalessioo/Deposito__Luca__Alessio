public class ProvaMath {
    public static void main(String[] args) {
        int a = 9;
        int b = 16;

        // Calcolo della radice quadrata
        double radiceA = Math.sqrt(a);
        double radiceB = Math.sqrt(b);

        // Calcolo del massimo tra due numeri
        int massimo = Math.max(a, b);
        int minimo = Math.min(a, b);

        Math.abs(-23);  // trasforma il -23 in 23

        // Elevamento a potenza (a^2)
        double potenza = Math.pow(a, 2);

        // Generazione di un numero casuale tra 0.0 e 1.0
        double casuale = Math.random();

        System.out.println("Radice quadrata di " + a + ": " + radiceA);
        System.out.println("Radice quadrata di " + b + ": " + radiceB);
        System.out.println("Il massimo tra " + a + " e " + b + ": " + massimo);
        System.out.println("Il minimo tra " + a + " e " + b + ": " + minimo); 
        System.out.println(a + " elevato alla seconda: " + potenza);
        System.out.println("Numero casuale: " + casuale);
    }
}