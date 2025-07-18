public class Application {
    public static void main(String[] args) {
        ComprovaIncapsulamento comprovaIncapsulamento = new ComprovaEreditarieta("Domanda 1", "Voto 10 :)")
    }
}

// classe comprova incapsulamento
class ComprovaIncapsulamento {

    private String nome ;
    private String password;   //Attributi privati

    

    public ComprovaIncapsulamento(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }
    // Metodi public per accedere all attributo privato
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}

// Classe comprova Ereditarieta
class ComprovaEreditarieta extends ComprovaIncapsulamento {

    public ComprovaEreditarieta(String nome, String password) {
        super(nome, password);
       
    }

    @Override
    public String getNome() {
        return "Ciaooo";
    }

}