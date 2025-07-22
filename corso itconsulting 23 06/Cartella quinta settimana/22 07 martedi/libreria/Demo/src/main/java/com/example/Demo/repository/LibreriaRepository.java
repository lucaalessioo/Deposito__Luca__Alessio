package com.example.Demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Demo.model.Libreria;

public interface LibreriaRepository extends JpaRepository<Libreria,Long>{
      List<Libreria> findByTitoloContainingIgnoreCase(String titolo);

      List<Libreria> findByAutoreContainingIgnoreCase(String autore);

      List<Libreria> findByTitolo(String titolo);
}
