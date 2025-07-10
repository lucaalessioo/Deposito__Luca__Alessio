public class ControlloCondizioni {

    public static void main(String[] args) {
    // prova if else
    int x = 20;
    int y = 18;
    if (x > y) {
    System.out.println("x is greater than y");
    } else {
        System.out.println("Sono entrato nell else");
    }

// if else if and else
 int time = 22;
 if (time < 10) {
  System.out.println("Good morning.");
 } else if (time < 18) {
  System.out.println("Good day.");
 } else {
  System.out.println("Good evening.");  // Outputs "Good evening.
 }
 

 // Operatore ternario
 int ternario = 20;
 String result = (ternario < 18) ? "Good day." : "Good evening.";
 System.out.println(result);


    }
}