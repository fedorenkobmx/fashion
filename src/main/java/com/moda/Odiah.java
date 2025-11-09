package com.moda;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odiah")
public class Odiah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_odiah")
    private int id_odiah;


    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "grudy")
    private String grudy;

    @Column(name = "talia")
    private String talia;

    @Column(name = "bedra")
    private String bedra;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "odiah_tkanina",
            joinColumns = @JoinColumn(name = "id_odiah"),
            inverseJoinColumns = @JoinColumn(name = "id_tkan")
    )
    private Set<Tkanina> tkaniny = new HashSet<>();

    public Odiah() {}

    public Odiah(String model, String grudy, String talia, String bedra) {
        this.model = model;
        this.grudy = grudy;
        this.talia = talia;
        this.bedra = bedra;
    }

    public int getId_odiah() { return id_odiah; }
    public String getModel() { return model; }
    public String getGrudy() { return grudy; }
    public String getTalia() { return talia; }
    public String getBedra() { return bedra; }

    public Set<Tkanina> getTkaniny() { return tkaniny; }
    public void setTkaniny(Set<Tkanina> tkaniny) { this.tkaniny = tkaniny; }

    @Override
    public String toString() {
        return model + " (" + grudy + "; " + talia + (bedra != null && !bedra.isEmpty() ? "; " + bedra : "") + ")";
    }
}