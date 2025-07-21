package com.example.demo.model;

public class Numero {
    private Long id;
    private int valore;

    public Numero() {
    }

    public Numero(Long id, int valore) {
        this.id = id;
        this.valore = valore;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }
}