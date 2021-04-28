package com.ftn.Taverna.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Artikal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Prodavac prodavac;
    private String naziv;
    private String opis;
    private Double cena;
    private String putanjaDoSlike;

}
