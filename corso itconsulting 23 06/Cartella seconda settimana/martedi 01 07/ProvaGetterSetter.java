public class ProvaGetterSetter {
    public static void main(String[] args) {
        
    }
}
// Classe persona
class Person {
    // Variabili d istanza
    private String nome;
    private int eta;

    // Getters and Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return this.eta;
    }

    public void setEta(int eta) {
        this.eta=eta;
    }

    private boolean verificaMaggiorenne() {
        return eta > 18;
    }

    public void stampaInfo() {
        if(verificaMaggiorenne())  {
            System.out.println(this.nome +"E' maggiorenne");
        } else {
            System.out.println(this.nome + "Non è maggiorenne");
        }
      }

}

