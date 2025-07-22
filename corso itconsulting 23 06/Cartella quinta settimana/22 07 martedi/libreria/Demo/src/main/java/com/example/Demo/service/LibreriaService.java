package com.example.Demo.service;

import org.springframework.stereotype.Service;

import com.example.Demo.model.Libreria;

import java.util.*;

@Service
public class LibreriaService {
private final List<Libreria> listaLibri = new ArrayList<>();


public List<Libreria> getAll() {
return listaLibri;
}

public Optional<Libreria> getByTitolo(String titolo) {
return listaLibri.stream().filter(t -> t.getTitolo().equals(titolo)).findFirst();
}

public Libreria create(Libreria nuovo) {
listaLibri.add(nuovo);
return nuovo;
}

public Optional<Libreria> update(String titolo, Libreria modificato) {
return getByTitolo(titolo).map(libro -> {
libro.setTitolo(modificato.getTitolo());
libro.setAutore(modificato.getAutore());
libro.setPrezzo(modificato.getPrezzo());

return libro;
});
}

public boolean delete(String titolo) {
return listaLibri.removeIf(t -> t.getTitolo().equals(titolo));
}
}
