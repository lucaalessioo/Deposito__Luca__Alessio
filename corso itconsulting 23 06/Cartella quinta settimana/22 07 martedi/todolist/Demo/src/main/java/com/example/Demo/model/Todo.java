package com.example.Demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data               //Getter e setter
@NoArgsConstructor  // Costruttore vuoto
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    private boolean completato;

    public Todo(String descrizione , boolean completato) {
        this.descrizione=descrizione;
        this.completato=completato;
    }
}
