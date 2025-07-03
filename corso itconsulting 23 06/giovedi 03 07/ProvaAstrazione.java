abstract class Animal {

  public abstract void animalSound(); }


class Pig extends Animal {

  public void animalSound() {

    System.out.println("The pig says: wee wee");

  } }

class Dog extends Animal {

  public void animalSound() {

    System.out.println("The dog says: bow wow");

  } }

class ProvaAstrazione {

  public static void main(String[] args) {

   // Animal myAnimal = new Animal();   ERRORE

    Animal myPig = new Pig(); 

    Animal myDog = new Dog();  

    //myAnimal.animalSound(); ERRORE

    myPig.animalSound();

    myDog.animalSound();

 }  }
