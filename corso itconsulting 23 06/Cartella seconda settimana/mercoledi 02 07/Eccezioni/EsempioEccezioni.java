public class EsempioEccezioni {

    public static void main(String[] args) {
        try {

            int a = 5;
            int b = 0;
            int c = a/b;
            System.out.println(c);

        }catch(Exception e) {
            e.printStackTrace();
            int d = 3/0;
            System.out.println(d);
        }
        finally {
            System.out.println("Finally");
        }
        System.out.println("programma terminato");
    }
}