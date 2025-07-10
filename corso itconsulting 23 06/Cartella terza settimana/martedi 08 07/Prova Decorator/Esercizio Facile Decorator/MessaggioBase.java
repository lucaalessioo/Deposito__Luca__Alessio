
// interfaccia Messaggio
interface Messaggio {
    String getContenuto();
} 

// Classe concreta dell interfaccia con il messaggio base
public class MessaggioBase implements Messaggio {

    @Override
    public String getContenuto() {
        return " Messaggio Base" ;
    }
}

// Classe astratta messaggio decoratore che implementa l interfaccia (QUESTO è IL DECORATOR)
abstract class MessaggioDecoratore implements Messaggio {
    protected Messaggio messaggio; // Variabile del tipo dell interfaccia cosi che accetta tutti i suoi tipi

    public MessaggioDecoratore(Messaggio messaggio) {       // Costruttore con parametro del tipo dell interfaccia
        this.messaggio = messaggio;
    }

    @Override
    public String getContenuto() {
        return messaggio.getContenuto();
    }
}

// Classe concreta che estende la classe astratta
class DecoratoreMaiuscolo extends MessaggioDecoratore {

    public DecoratoreMaiuscolo(Messaggio messaggio) {
        super(messaggio); // Richiamo il cosruttore della classe astratta per istanziare l ogetto
    }

    // Override con richiamo del metodo getContenuto della classe astratta ma con il metodo uppercase per le maiuscole
    @Override
    public String getContenuto() {
        return super.getContenuto().toUpperCase();
    }
}

