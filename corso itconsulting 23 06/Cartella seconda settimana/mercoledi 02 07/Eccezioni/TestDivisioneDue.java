import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDivisioneDue {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Prova eccezione custom
            System.out.println("Inserisci un nome: ");
            String nome = scanner.nextLine();

            StringValidator.check(nome);

            // Prova con divisione
            System.out.println("Inserisci un numero: ");
            int numero = scanner.nextInt();
            int risultato = EsercizioDivisione.divisioneUnchecked(10, 1);
            System.out.println(risultato);
            // catch multipli
        } catch(TooShortStringException e) {
            System.out.println(e.getMessage());
            
        } catch (InputMismatchException | ArithmeticException e ) {
            e.printStackTrace();

        } /*catch (ArithmeticException e) {
            e.printStackTrace();
        }*/ catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class StringValidator {

    public static void check(String s) throws TooShortStringException {
        if(s.length() < 8 ) {

            throw new TooShortStringException("Stringa troppo corta! ",null);

        }
    }
}
