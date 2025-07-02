import java.util.Scanner;

public class EsempioEccezioniTre {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            
            System.out.println("Inserisci un numero: ");
            int numero = scanner.nextInt();
            System.out.println(numero);
            int x = numero/0;
            System.out.println(x);

       } catch (Exception e) {
            e.printStackTrace();
       }
    }
}
