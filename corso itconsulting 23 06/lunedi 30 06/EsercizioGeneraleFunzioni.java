import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EsercizioGeneraleFunzioni {
    public static void main(String[] args) {
        Random random = new Random(); 
        // Creo lo scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Benvenuto nel menu dell'esercizio\n");

        // Ciclo infinito per il menu
        while (true) {
            System.out.println("\n--- Menu per scegliere cosa fare ---");
            System.out.println("Digita 1. Funzione base");
            System.out.println("Digita 2. Funzione multiply interi");
            System.out.println("Digita 3. Funzione multiply numeri con virgola mobile");
            System.out.println("Digita 4. Funzione ricorsiva");
            System.out.println("Digita 5. Funzione passaggio per valore e per riferimento");
            System.out.println("Digita 6. Funzione stampa elementi arraylist.");
            System.out.println("Digita 7. Esci");

            int scelta = scanner.nextInt();

            // Funzione base
            if (scelta == 1) {
                System.out.println("Funzione per il calcolo della somma di due numeri\n");
                System.out.println("Inserisci il primo numero: ");
                int numero1 = scanner.nextInt();
                System.out.println("Inserisci il secondo numero ");
                int numero2 = scanner.nextInt();

                int risultato = funzioneBase(numero1, numero2);
                System.out.println("Il risultato finale è: " + risultato);
                System.out.println();
            }

            // Funzione multiply con numeri interi
            if(scelta == 2) {
                System.out.println("Funzione per il calcolo della moltiplicazione di due numeri interi! \n");
                System.out.println("Inserisci il primo numero intero: ");
                int num1 = scanner.nextInt();
                System.out.println("Inserisci il secondo numero intero: ");
                int num2 = scanner.nextInt();

                System.out.println(" Il risultato è : " +multiply(num1, num2));
                System.out.println(); 
            }

            // Funzione multiply con numeri in virgola mobile
                if(scelta == 3) {
                System.out.println("Funzione per il calcolo della moltiplicazione di tre numeri con virgola mobile! \n");
                System.out.println("Inserisci il primo numero con virgola: ");
                double num1 = scanner.nextDouble();
                System.out.println("Inserisci il secondo numero con virgola: ");
                double num2 = scanner.nextDouble();
                System.out.println("Inserisci il terzo numero con virgola: ");
                double num3 = scanner.nextDouble();

                System.out.println(" Il risultato è : " +multiply(num1, num2, num3)); 
                System.out.println();
            }

            // Funzione ricorsiva
            if (scelta == 4) {
                System.out.println("Funzione ricorsiva del numero inserito ! \n");
                System.out.println("Inserisci il numero da sommare: ");
                int n = scanner.nextInt();
                int risultato = funzioneRicorsiva(n);

                System.out.println("Il risultato è: " + risultato);
                System.out.println();
            }

            // Funzione per passaggio per valore o riferimento
            if (scelta == 5) {
                System.out.println("Digita 1. Modifica per valore, Digita 2. Modifica per riferimento");
                int valore = scanner.nextInt();
            
            // Per Valore
                if (valore == 1) {
                    System.out.println("Inserisci un numero");
                    int n = scanner.nextInt();
                    System.out.println(passaggioPerValore(n));
                }
            
            // Per Riferimento
                if (valore == 2) {
                    
            // Creazione dell' array con ciclo per la stampa 
                    int[] array = {1, 2};
                    System.out.println("Prima");
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                    }
                    System.out.println();
            // Richiamo della funzione con ciclo per la stampa
                    array = passaggioPerRiferimento(array);
                    System.out.println("Dopo");
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                    }
                    System.out.println();
                }
            }

            // Funzione per stampare gli elementi dell arraylist
            if(scelta == 6) {
                System.out.println("Funzione per stampare gli elemnti di un array list! \n ");
                ArrayList<Integer> arrayList = new ArrayList<>();   // Creazione dell arraylist
                
                // Ciclo per riempire l array. lunghezza 10 con utilizzo della classe random 
                for(int i = 0 ; i<10 ; i++) {
                    Integer numero = random.nextInt(100) +1;    // numeri compresi tra 0 e 100
                    arrayList.add(numero);     // aggiungo l elemento nella arraylist
                }
                System.out.println("Gli elementi dell array sono : ");
                Collections.sort(arrayList);            // Ordino l arraylist
                stampaElementiArrayList(arrayList);         // richiamo della funzione  stampaElementiArrayList
            }

            // Uscita
            if (scelta == 7) {
                System.out.println("Arrivederci!");
                scanner.close();
                return;
            }
        }
    }

    // Funzione base
    public static int funzioneBase(int a, int b) {
        return a + b;
    }
    // Moltiplicazione di due interi
    public static int multiply(int a, int b) {
    return a * b;
    }

    // Moltiplicazione di tre numeri con virgola mobile (double)
    public static double multiply(double a, double b, double c) {
    return a * b * c;
    }

    // Funzione ricorsiva per calcolare la somma
    public static int funzioneRicorsiva(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n + funzioneRicorsiva(n - 1);
        }
    }

    // Passaggio per valore 
    public static int passaggioPerValore(int n) {
        return n = n * 10;
    }

    // Passaggio per riferimento
    public static int[] passaggioPerRiferimento(int[] n) {
        for (int i = 0; i < n.length; i++) {
            n[i] = n[i] * 10;
        }
        return n;
    }

    // Fuznione per la stampa dell arraylist
    public static void stampaElementiArrayList(ArrayList<Integer> listaNumeri) {
     for(Integer numero :  listaNumeri) {
        System.out.print(numero + " ");
     }
    }

}
