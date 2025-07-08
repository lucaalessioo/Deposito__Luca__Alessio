 // Interfaccia Component
 interface Component {
    void operation();
    
}
// Component Concreto
class ConcreteComponent implements Component{

    @Override
    public void operation() {
       System.out.println("Operazione base");
    }

}
// Decorator astratto
abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
    public void operation() {
        component.operation();
    }
}
// Decorator concreto
public class ConcrateDecoratorA extends Decorator {

    public ConcrateDecoratorA(Component component) {
        super(component);
     
    }
    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalita A");
    }
}

/*Interfaccia Component: è una classe astratta
o un'interfaccia che definisce l'interfaccia
comune sia per i componenti concreti che per
i decoratori. Specifica le operazioni che
possono essere eseguite sugli oggetti.


Componente Concreto: sono gli oggetti o le
classi di base che implementano
l'interfaccia Component. Sono gli oggetti a
cui vogliamo aggiungere nuovi comportamenti
o responsabilità.


Decorator: è una classe astratta che
implementa anch'essa l'interfaccia Component
e mantiene un riferimento a un oggetto
Component. I decoratori sono responsabili
dell'aggiunta di nuovi comportamenti
all'oggetto Component incapsulato.


Decoratore Concreto: sono le classi concrete
che estendono la classe Decorator.
Aggiungono comportamenti o responsabilità
specifiche al componente. Ogni decoratore
concreto può aggiungere uno o più
comportamenti al componente. */