package com.ftn.Taverna.model.DTO.post;


import com.ftn.Taverna.model.Akcija;
import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.DTO.ArtikalDTO;
import com.ftn.Taverna.model.DTO.ProdavacDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AkcijaDTOPost {

    private Integer id;
    private Integer prodavac;
    private List<Integer> artikli = new ArrayList<>();
    private Integer procenat;
    private Date odKad;
    private Date doKad;
    private String tekst;





    public AkcijaDTOPost(Akcija akcija){
        this.id = akcija.getId();
        this.prodavac = akcija.getProdavac().getId();
        this.procenat = akcija.getProcenat();
        this.odKad = akcija.getOdKad();
        this.doKad = akcija.getDoKad();
        this.tekst = akcija.getTekst();
        for (Artikal a: akcija.getArtikli()) {
            this.artikli.add(a.getId());
        }
    }







}
