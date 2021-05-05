package com.ftn.Taverna.model.DTO.post;


import com.ftn.Taverna.model.Akcija;
import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.DTO.ArtikalDTO;
import com.ftn.Taverna.model.DTO.ProdavacDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AkcijaDTOPost {

    @NotEmpty
    private Integer id;

    @NotEmpty
    private Integer prodavac;
    @NotEmpty
    private Integer procenat;

    @NotNull
    private Date odKad;

    @NotNull
    private Date doKad;

    @NotBlank
    private String tekst;


    public AkcijaDTOPost(Akcija akcija){
        this.id = akcija.getId();
        this.prodavac = akcija.getProdavac().getId();
        this.procenat = akcija.getProcenat();
        this.odKad = akcija.getOdKad();
        this.doKad = akcija.getDoKad();
        this.tekst = akcija.getTekst();
    }







}
