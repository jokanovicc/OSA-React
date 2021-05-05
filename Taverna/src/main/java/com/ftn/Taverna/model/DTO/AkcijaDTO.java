package com.ftn.Taverna.model.DTO;


import com.ftn.Taverna.model.Akcija;
import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.Prodavac;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AkcijaDTO {


    @NotEmpty
    private Integer id;

    @NotNull
    private ProdavacDTO prodavac;

    @NotEmpty
    private Integer procenat;

    @NotNull
    private Date odKad;

    @NotEmpty
    private Date doKad;

    @NotEmpty
    private String tekst;




    public AkcijaDTO(Akcija akcija){
        this.id = akcija.getId();
        this.prodavac = new ProdavacDTO(akcija.getProdavac());
        this.procenat = akcija.getProcenat();
        this.odKad = akcija.getOdKad();
        this.doKad = akcija.getDoKad();
        this.tekst = akcija.getTekst();
    }



}
