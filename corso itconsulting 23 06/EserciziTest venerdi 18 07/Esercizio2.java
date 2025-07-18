import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Esercizio2 {
    public static void main(String[] args) {
        
    
    
        String url = "jdbc:mysql://localhost:3306/db"; 
        String utente = "username";                            
        String password = "password";                 

        
        Connection connessione = null;
        PreparedStatement queryPrecompilata = null;
        ResultSet risultati = null;

        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver"); // Caricamento del driver

            // richiamo la connessione
            connessione = DriverManager.getConnection(url, utente, password);
            System.out.println("Connessione al database riuscita!");

            // Query
            String sql = "SELECT id, nome, cognome FROM studenti";
            queryPrecompilata = connessione.prepareStatement(sql);

            // eseguo la query col prepared statement
            risultati = queryPrecompilata.executeQuery();

            System.out.println("\nLista degli Studenti");
            
            while (risultati.next()) { 
                int id = risultati.getInt("id");       
                String nome = risultati.getString("nome"); 
                String cognome = risultati.getString("cognome"); 
                System.out.println("ID: " + id + ", Nome: " + nome + ", Cognome: " + cognome);
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Errore: Driver MySQL non trovato! Hai aggiunto il .jar al progetto?");
            e.printStackTrace();
        } catch (SQLException e) {
          
            System.err.println("Errore col database: " + e.getMessage());
            e.printStackTrace();
        } 
}
}


CREATE DATABASE IF NOT EXISTS db;

USE db;

CREATE TABLE IF NOT EXISTS studenti (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    eta INT
);

INSERT INTO studenti (nome, cognome, eta) VALUES ('Luca', 'Alessio', 29);
INSERT INTO studenti (nome, cognome, eta) VALUES ('Jacopo', 'De Martino', 27);
INSERT INTO studenti (nome, cognome, eta) VALUES ('Damiano', 'De Martino', 27);