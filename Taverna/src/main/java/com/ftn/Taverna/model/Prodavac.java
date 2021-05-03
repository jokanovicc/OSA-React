package com.ftn.Taverna.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Prodavac extends KorisnikAbstract {

    private Date poslujeOd;
    private String imejl;
    private String adresa;
    private String naziv;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "prodavac")
    private Set<Artikal> artikli = new HashSet<Artikal>();

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "prodavac")
    private Set<Akcija> akcije = new HashSet<Akcija>();

}
