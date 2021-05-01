package com.ftn.Taverna.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
public class Porudzbina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Kupac kupac;
    private Date satnica;
    private boolean dostavljeno;
    private Integer ocena;
    private String komentar;
    private boolean anonimanKomentar;
    private boolean arhiviranKomentar;
}
