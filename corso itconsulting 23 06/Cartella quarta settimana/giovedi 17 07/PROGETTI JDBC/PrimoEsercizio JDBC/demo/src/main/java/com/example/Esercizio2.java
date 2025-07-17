package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Esercizio2 {
   
        
        // Costanti statiche per la connessione al db
    private static final String url = "jdbc:mysql://localhost:3306/sakila"; 
    private static final String user = "";
    private static final String password = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nMenu Noleggi Film");
            System.out.println("1. Stampa la lista dei clienti il cui nome inizia con la lettera A");
            System.out.println("2. Conta quanti clienti sono registrati in ogni city");
            System.out.println("3. Mostra i 5 clienti piu recenti in ordine di creazione");
            System.out.println("4. Ordina dal piu vecchio al piu recente stampando nome e data creazione");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            choice = scanner.nextInt();

            // Se scelgo 1 mi richiama il metodo con all interno la query
            switch (choice) {
                case 1:
                    stampaClientiConLetteraA();
                    break;
                case 2: 
                    contaClinetiPerCitta();
                    break;
                case 3: 
                    primi5UtentiCreati();
                    break;
                case 4:
                    stampaUtentiDESC();
                    break;
                case 0:
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void primi5UtentiCreati() {
        String query = "SELECT * FROM customer ORDER BY create_date DESC LIMIT 5 ";

        // Utilizzo un try with resource per provare la creazione della connessione
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

                 System.out.println("\nQuesti sono gli ultimi 5 clienti creati!");

                  while(rs.next()) {
                    String first_name = rs.getString("first_name");
                    
                    System.out.println("Nome utente = " + first_name );
                 }

             }catch(SQLException e) {
                System.err.println("Errore durante il recupero dei customer: " + e.getMessage());
             }

    }

    private static void stampaUtentiDESC() {
        String query = "SELECT * FROM customer ORDER BY create_date";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

                 System.out.println("\nQuesti sono i clienti creati!");

                  while(rs.next()) {
                    String first_name = rs.getString("first_name");
                    
                    System.out.println("Nome utente = " + first_name );
                 }

             }catch(SQLException e) {
                System.err.println("Errore durante il recupero dei customer: " + e.getMessage());
             }

    }

    private static void contaClinetiPerCitta() {

        String query = "SELECT c.city, COUNT(*) AS NumeroCustomer FROM City c JOIN Address a ON c.city_id = a.city_id JOIN Customer co ON a.address_id = co.address_id GROUP BY c.city LIMIT 10";

        // Utilizzo un try with resource per provare la creazione della connessione
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

                 System.out.println("\nQuesti sono i clienti contati per citta");

                 while(rs.next()) {
                    String nomeCitta = rs.getString("city");
                    int numeroCustomer = rs.getInt("NumeroCustomer");
                    System.out.println("Nome citta = " + nomeCitta + " Numero Totale: "+numeroCustomer);
                 }


             } catch (SQLException e) {
            System.err.println("Errore durante il recupero dei customer: " + e.getMessage());
        }
    }

    // Metodo statico con la query per la stampa dei film piu noleggiata
    private static void stampaClientiConLetteraA() {
        String sql = "SELECT * FROM Customer WHERE first_name LIKE 'a%' ";
                   

        // Lista di film noleggiati
        List<Customer> customerList = new ArrayList<>();

        // Utilizzo un try with resource per provare la creazione della connessione
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nQuesti sono i clienti con la lettera A come iniziale");

            // Ciclo l intero result set finche ho dati
            while (rs.next()) {
                String first_name = rs.getString("first_name");        // Salvo la stringa col titolo
                    // Salvo l intero con il retal_count
                customerList.add(new Customer(first_name));         // Aggiungo il film noleggiato alla lista
            }

            // Se la lista è vuota errore
            if (customerList.isEmpty()) {
                System.out.println("Nessun film trovato o dati di noleggio non disponibili.");
                // Altrimenti ciclo la lista dei film e stampo i dettagli 
            } else {
                for (Customer customer : customerList) {
                    System.out.println("Customer: " + customer.getFirst_name());
                }
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dei customer: " + e.getMessage());
        }
    }

    // Classe interna per rappresentare un film con il suo conteggio di noleggi (Entita)
    static class Customer {
        private String first_name;

        public Customer(String first_name) {
            this.first_name = first_name;
           
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        
    }
}
