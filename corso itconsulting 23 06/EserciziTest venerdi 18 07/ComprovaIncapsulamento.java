public class ComprovaIncapsulamento {

    private String nome ;
    private String password;   //Attributi privati

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