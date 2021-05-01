package com.ftn.Taverna.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass

@Data
public abstract class KorisnikAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String ime;
    private String prezime;
    private String korisnicko;
    private String sifra;
    private boolean blokiran;
}
