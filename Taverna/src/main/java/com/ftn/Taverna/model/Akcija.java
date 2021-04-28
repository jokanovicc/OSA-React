package com.ftn.Taverna.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
public class Akcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Prodavac prodavac;

    @ManyToOne
    private Artikal artikal;

    private Integer procenat;
    private Date odKad;
    private Date doKad;
    private String tekst;
}
