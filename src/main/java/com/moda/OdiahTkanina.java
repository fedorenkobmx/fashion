package com.moda;

import jakarta.persistence.*;

@Entity
@Table(name = "odiah_tkanina")
public class OdiahTkanina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_odiah")
    private Odiah odiah;

    @ManyToOne
    @JoinColumn(name = "id_tkanina")
    private Tkanina tkanina;

    public OdiahTkanina() {}

    public OdiahTkanina(Odiah odiah, Tkanina tkanina) {
        this.odiah = odiah;
        this.tkanina = tkanina;
    }
}
