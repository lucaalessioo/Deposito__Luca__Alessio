package com.example.Demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data               //Getter e setter
@NoArgsConstructor  // Costruttore vuoto
@Entity
public class Libreria {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titolo", nullable = false, length = 100)
    private String titolo;
    private String autore;
    private double prezzo;

    public Libreria(String titolo, String autore, double prezzo) {
        this.titolo=titolo;
        this.titolo=titolo;
        this.prezzo=prezzo;
    }
}
