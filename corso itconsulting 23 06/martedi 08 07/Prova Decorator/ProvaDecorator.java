public class ProvaDecorator {
public static void main(String[] args) {
        // Istanza del componente base
        Component componenteBase = new ConcreteComponent();

        // Decorazione con ConcrateDecoratorA
        Component componenteDecorato = new ConcrateDecoratorA(componenteBase);

        // Esecuzione dell'operazione
        componenteDecorato.operation();
}
    
}