package com.moda;

import jakarta.persistence.*;

@Entity
@Table(name = "tkanina")
public class Tkanina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tkan")
    private int id_tkan;

    @Column(name = "nazva", nullable = false)
    private String nazva;

    public Tkanina() {}

    public Tkanina(String nazva) {
        this.nazva = nazva;
    }

    public int getId_tkan() { return id_tkan; }
    public String getNazva() { return nazva; }
}