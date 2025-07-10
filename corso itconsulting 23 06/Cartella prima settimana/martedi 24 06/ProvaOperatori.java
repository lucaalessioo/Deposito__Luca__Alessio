public class ProvaOperatori {
    public static void main(String[] args) {

        // Dichiaro una variabile intera e gli assegno 10
        int x = 10;

        System.out.println(x);
        // prova operatori aritmetici
        x += 10;  
        System.out.println(x);
        x -= 5;
        System.out.println(x);
        x *= 2;
        System.out.println(x);
        x /= 2;
        System.out.println(x);

        x++;
        System.out.println(x);
        x--;
        System.out.println(x);

        // operatori di confornto
        int a = 10;
        int b = 5;

        System.out.println(a<b);
        System.out.println();
        System.out.println(a>b);
        System.out.println();
        System.out.println(a>=b);
        System.out.println();
        System.out.println(a<=b);
        System.out.println();
        System.out.println(a!=b);
        System.out.println();
        System.out.println(a==b);

        //operatori logici

        System.out.println(a<b && b>2);
        System.out.println(a<b || b>2);
        System.out.println(!(a<b && b>2));


    }
}
