package com.example.Demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                       //Getter e setter
@NoArgsConstructor          // Costruttore vuoto
@AllArgsConstructor         // Costruttore parametrico
public class Libreria {
    private String titolo;
    private String autore;
    private double prezzo;
}
