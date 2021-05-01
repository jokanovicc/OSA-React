package com.ftn.Taverna.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
public class Prodavac extends KorisnikAbstract {

    private Date poslujeOd;
    private String imejl;
    private String adresa;
    private String naziv;

}
