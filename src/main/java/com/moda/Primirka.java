package com.moda;

import jakarta.persistence.*;

@Entity
@Table(name = "primirka")
public class Primirka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_primirka")
    private int id_primirka;

    @Column(name = "data_primirky", length = 100)
    private String dataPrimirky;

    @ManyToOne
    @JoinColumn(name = "id_atelie")
    private Atelie atelie;

    @ManyToOne
    @JoinColumn(name = "id_odiah")
    private Odiah odiah;

    @ManyToOne
    @JoinColumn(name = "id_pokupets")
    private Pokupets pokupets;

    public Primirka() {}

    public Primirka(String dataPrimirky, Atelie atelie, Odiah odiah, Pokupets pokupets) {
        this.dataPrimirky = dataPrimirky;
        this.atelie = atelie;
        this.odiah = odiah;
        this.pokupets = pokupets;
    }

    public int getId_primirka() { return id_primirka; }
    public String getDataPrimirky() { return dataPrimirky; }
    public Atelie getAtelie() { return atelie; }
    public Odiah getOdiah() { return odiah; }
    public Pokupets getPokupets() { return pokupets; }
}