package com.ftn.Taverna.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
public class Prodavac {

    @Id
    private Integer id;
    private Date poslujeOd;
    private String imejl;
    private String adresa;
    private String naziv;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id")
    @MapsId
    private Korisnik korisnik;

}
