import java.util.Scanner;

public class EsempioEccezioniDue {
    public static void main(String[] args) {
        Scanner scanner = null;

       try {
            scanner = new Scanner(System.in);
            System.out.println("Inserisci un numero: ");
            int numero = scanner.nextInt();
            System.out.println(numero);
            int x = numero/0;
            System.out.println(x);

       } catch (Exception e) {
            e.printStackTrace();
       }
       finally {
        scanner.close();
       }
    }
}
