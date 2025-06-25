public class EsercizioFinaleCondizioniExtra {
    public static void main(String[] args) {
        // Genero un'età casuale tra 1 e 90 anni
        int eta = 1 + (int)(Math.random() *90); // Età tra 1 e 90
        System.out.println("Età: " + eta);

        // Controllo se l'età è valida (compresa tra 18 e 40)
        if(eta >= 18 && eta <= 40) {
            // Genero un tempo casuale nei 100 metri tra 10 e 15 secondi
            double tempo = 1 + (int)(Math.random() * 20); // generazione random del tempo
            System.out.println("Tempo nei 100 metri: " + tempo);

            // Controllo se il tempo è sufficentemente basso
            if(tempo < 12) {
                // Genero il peso casuale tra 50 e 120 kg
                double peso = 50 + Math.random() * 70; // Peso tra 50 e 120 kg
                System.out.println("Peso: " + peso);

                // Genero l'altezza casuale tra 1.50 e 2.00 metri
                double altezza = 1.50 + Math.random() * 0.50; // Altezza tra 1.50 e 2.00 metri
                System.out.println("Altezza: " + altezza);

              
                double bmi = peso / Math.pow(altezza, 2); // Calcolo il BMI con Math.pow
                
                // Utilizzo Math.sqrt() per calcolare la radice quadrata dell'BMI
                double radiceBmi = Math.sqrt(bmi);
                System.out.println("Indice di Massa Corporea (bmi): " + bmi);
                System.out.println("Radice quadrata dell'BMI: " + radiceBmi);

                // Controllo se il BMI è adeguato
                if(bmi < 25) {
                    System.out.println("Ammesso alla gara");
                } else {
                    System.out.println("Non ammesso alla gara perché il BMI è troppo alto!");
                }

            } else {
                System.out.println("Non ammesso perché il tempo è troppo alto!");
            }
            
        } else {
            System.out.println("Non ammesso alla gara, età non valida!");
        }
    }
}
