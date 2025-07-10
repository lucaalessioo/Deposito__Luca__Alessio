// Interfaccia Strategy
interface Strategy {
    void execute();
}

// Strategie Concrete
class ConcreteStrategyA implements Strategy {
    public void execute() {
        System.out.println("Strategia A eseguita.");
    }
}

class ConcreteStrategyB implements Strategy {
    public void execute() {
        System.out.println("Strategia B eseguita.");
    }
}

// Context
public class Context {
    private Strategy strategy;  // Serve per richiamare il metodo dell interfaccia

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performTask() {
        strategy.execute();
    }
}


