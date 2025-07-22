package com.example.Demo.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.Demo.model.Libreria;
import com.example.Demo.service.LibreriaService;

import java.util.List;

@RestController
@RequestMapping("/api/libreria")
public class LibreriaController {

    private final LibreriaService service;

    public LibreriaController(LibreriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libreria> getAll() {
        return service.getAll();
    }

    @GetMapping("/{titolo}")
    public ResponseEntity<Libreria> getById(@PathVariable String titolo) {
        return service.getByTitolo(titolo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libreria> create(@RequestBody Libreria nuovo) {
        Libreria creato = service.create(nuovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PutMapping("/{titolo}")
    public ResponseEntity<Libreria> update(@PathVariable String titolo, @RequestBody Libreria modificato) {
        return service.update(titolo, modificato)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{titolo}")
    public ResponseEntity<Void> delete(@PathVariable String titolo) {
        boolean rimosso = service.delete(titolo);
        return rimosso ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}