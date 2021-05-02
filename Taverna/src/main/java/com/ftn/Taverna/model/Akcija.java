package com.ftn.Taverna.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Akcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Prodavac prodavac;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Artikal> artikli = new ArrayList<>();

    private Integer procenat;
    private Date odKad;
    private Date doKad;
    private String tekst;
}
