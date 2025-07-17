package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Costanti statiche per la connessione al db
    private static final String url = "jdbc:mysql://localhost:3306/sakila"; 
    private static final String user = "root";
    private static final String password = "root";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nMenu Noleggi Film");
            System.out.println("1. Mostra i 10 film più noleggiati (dal meno al più)");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            choice = scanner.nextInt();

            // Se scelgo 1 mi richiama il metodo con all interno la query
            switch (choice) {
                case 1:
                    mostraFilmPiuNoleggiati();
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

    // Metodo statico con la query per la stampa dei film piu noleggiata
    private static void mostraFilmPiuNoleggiati() {
        String sql = "SELECT f.title AS film_title, COUNT(r.rental_id) AS rental_count " +
                     "FROM rental r " +
                     "JOIN inventory i ON r.inventory_id = i.inventory_id " +
                     "JOIN film f ON i.film_id = f.film_id " +
                     "GROUP BY f.title " +
                     "ORDER BY rental_count ASC " +
                     "LIMIT 10;";

        // Lista di film noleggiati
        List<FilmNoleggiato> filmList = new ArrayList<>();

        // Utilizzo un try with resource per provare la creazione della connessione
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nQuesti sono i 10 film piu noleggiati");

            // Ciclo l intero result set finche ho dati
            while (rs.next()) {
                String title = rs.getString("film_title");        // Salvo la stringa col titolo
                int rentalCount = rs.getInt("rental_count");      // Salvo l intero con il retal_count
                filmList.add(new FilmNoleggiato(title, rentalCount));         // Aggiungo il film noleggiato alla lista
            }

            // Se la lista è vuota errore
            if (filmList.isEmpty()) {
                System.out.println("Nessun film trovato o dati di noleggio non disponibili.");
                // Altrimenti ciclo la lista dei film e stampo i dettagli 
            } else {
                for (FilmNoleggiato film : filmList) {
                    System.out.println("Film: " + film.getTitle() + " - Noleggi: " + film.getRentalCount());
                }
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dei film: " + e.getMessage());
        }
    }

    // Classe interna per rappresentare un film con il suo conteggio di noleggi (Entita)
    static class FilmNoleggiato {
        private String title;
        private int rentalCount;

        public FilmNoleggiato(String title, int rentalCount) {
            this.title = title;
            this.rentalCount = rentalCount;
        }

        public String getTitle() {
            return title;
        }

        public int getRentalCount() {
            return rentalCount;
        }
    }
}