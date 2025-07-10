import java.util.Arrays;

public class ProvaStringhe {
    public static void main(String[] args) {
        /*
        // Creo una stringa
        String provaStringhe = "ciao";
        System.out.println("La lunghezza della stringa è : " +provaStringhe.length());  // Richiamo il metodo length per sapere la lunghezza della stringa

        String txt = "Hello World";
        System.out.println(txt.toUpperCase()); // Outputs "HELLO WORLD"
        System.out.println(txt.toLowerCase()); // Outputs "hello world

         String tx = "Please locate where 'locate' occurs!";
         System.out.println(tx.indexOf("locate")); // Outputs 7
         */

         
        //prova \t TAB  genera uno spazio
        System.out.println(" ciao mi chiamo \tluca");

        //prova \b backspace  cancella dello spazio
        System.out.println(" ciao mi chiamo \bluca");

        //prova \r carriage return  riporta indietro il valore al punto di partenza
        System.out.println(" ciao mi chiamo \rluca");

        // prova \n new line  manda a capo
        System.out.println(" ciao mi chiamo \nluca");

        //prova \f form feed
        System.out.println(" ciao mi chiamo \f luca");

        // utilizzo del metodo split
       String str = "Hello World";
       String[] words = str.split("\\s");
       System.out.println(Arrays.toString(words));

     




    }
}
