package com.example.Demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Demo.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
// Tutti i metodi CRUD già pronti!
}
