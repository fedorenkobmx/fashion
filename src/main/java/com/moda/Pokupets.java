package com.moda;

import jakarta.persistence.*;

@Entity
@Table(name = "pokupets")
public class Pokupets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pokupets")
    private int id_pokupets;


    @Column(name = "pib", nullable = false)
    private String pib;

    @Column(name = "riven_klienta")
    private String rivenKlienta;

    @Column(name = "telefon")
    private String telefon;

    public Pokupets() {}

    public Pokupets(String pib, String rivenKlienta, String telefon) {
        this.pib = pib;
        this.rivenKlienta = rivenKlienta;
        this.telefon = telefon;
    }

    public int getId_pokupets() { return id_pokupets; }
    public String getPib() { return pib; }
    public String getRivenKlienta() { return rivenKlienta; }
    public String getTelefon() { return telefon; }
}