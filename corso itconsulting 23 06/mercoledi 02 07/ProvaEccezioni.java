public class ProvaEccezioni {
    public static void main(String[] args) {
        try {
            EsercizioDivisione.divisioneChecked(10, 0);    // metodo checked
            try {
                EsercizioDivisione.divisioneUnchecked(10,2);   // metodo unchecked

            }catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println("Ciao");

        } catch(Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("Programma terminato!");
    }
}

class EsercizioDivisione {

    // Metodo che lancia una eccezione controllata
    public static int divisioneChecked(int a , int b) throws Exception {

    if(b==0) {
        throw new Exception();        // Lancio una eccezione di tipo Exception
    }
    return a/b;
}

// Metodo con eccezzione Unchecked
public static int divisioneUnchecked(int a , int b)  {

    if(b==0) {
        throw new RuntimeException();    // lancio una eccezione di tipo RunTimeException
    }
    return a/b;
}
}
