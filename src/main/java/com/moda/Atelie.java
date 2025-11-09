package com.moda;

import jakarta.persistence.*;

@Entity
@Table(name = "atelie")
public class Atelie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atelie")
    private int id_atelie;

    @Column(name = "nazva", nullable = false)
    private String nazva;

    @Column(name = "adres")
    private String adres;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "stazh_kutyrie")
    private String stazhKutyrie;

    public Atelie() {}

    public Atelie(String nazva, String adres, String telefon, String stazhKutyrie) {
        this.nazva = nazva;
        this.adres = adres;
        this.telefon = telefon;
        this.stazhKutyrie = stazhKutyrie;
    }

    public int getId_atelie() { return id_atelie; }
    public String getNazva() { return nazva; }
    public String getAdres() { return adres; }
    public String getTelefon() { return telefon; }
    public String getStazhKutyrie() { return stazhKutyrie; }
}