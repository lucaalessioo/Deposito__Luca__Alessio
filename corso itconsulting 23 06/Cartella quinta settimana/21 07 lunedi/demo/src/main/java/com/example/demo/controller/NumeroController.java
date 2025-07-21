package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Numero;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/numeri") 
public class NumeroController {

    private List<Numero> numeri = new ArrayList<>(); 
    private Long idCounter = 1L;

    // 1. Vedere la lista di numeri (GET)
    @GetMapping
    public List<Numero> getAll() {
        return numeri;
    }

    // 2. Aggiungere numeri a un array con la POST
    @PostMapping
    public Numero crea(@RequestBody Numero nuovo) { // Accetta un oggetto Numero nel corpo
        nuovo.setId(idCounter++);
        numeri.add(nuovo);
        return nuovo;
    }

    // Vedere un numero specifico per ID (GET)
    @GetMapping("/{id}")
    public Numero getById(@PathVariable Long id) {
        return numeri.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Aggiornare un numero esistente (PUT)
    @PutMapping("/{id}")
    public Numero aggiorna(@PathVariable Long id, @RequestBody Numero modificato) {
        for (Numero n : numeri) { // Itera sui numeri
            if (n.getId().equals(id)) {
                n.setValore(modificato.getValore()); // Aggiorna solo il valore
                return n;
            }
        }
        return null; 
    }

    // 3. Vedere la somma totale dei numeri (GET)
    @GetMapping("/somma") 
    public String getSommaTotale() {
        long somma = 0;
        for (Numero n : numeri) {
            somma += n.getValore(); // Somma i valori dei numeri
        }
        return "La somma totale dei numeri è: " + somma;
    }


    // 4. Rimuovere dei numeri (DELETE)
    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        boolean rimosso = numeri.removeIf(n -> n.getId().equals(id)); // Rimuove per ID del Numero
        if (rimosso) {
            return "Numero eliminato con successo.";
        } else {
            return "Numero con ID " + id + " non trovato.";
        }
    }
}
