import java.util.Scanner;

public class EsercizioFinaleCondizioni {
    public static void main(String[] args) {
        Scanner interi = new Scanner(System.in);
        
        // Chiedo l'età
        System.out.println("inserisci la tua eta: ");
        int eta = interi.nextInt();

        // Controllo se l eta è valida
        if(eta >= 18 && eta <= 40) {
            System.out.println("inserisci il tuo tempo nei 100 metri: ");
            double tempo = interi.nextDouble();

            // Controllo se il tempo è sufficentemente basso
            if(tempo < 12) {
                System.out.println("Inserisci il tuo peso: ");
                double peso = interi.nextDouble();

                System.out.println("Inserisci la tua altezza: ");
                double altezza = interi.nextDouble();

                double bmi = peso / Math.pow(altezza , 2);
                
                // Utilizzo Math.sqrt() per calcolare la radice quadrata dell'BMI
                double radiceBmi = Math.sqrt(bmi);
                System.out.println("Indice di Massa Corporea (bmi): " + bmi);
                System.out.println("Radice quadrata dell'BMI: " + radiceBmi);



                // Controllo se il bmi è adeguato
                if(bmi < 25) {
                    System.out.println("Ammesso alla gara");

                } else System.out.println("Non ammesso alla gara perche il bmi troppo alto!");

            } else System.out.println("Non ammesso perche il tempo è troppo alto! ");
            
        } else System.out.println("Non ammesso alla gara eta non valida!");

       
    }
}
