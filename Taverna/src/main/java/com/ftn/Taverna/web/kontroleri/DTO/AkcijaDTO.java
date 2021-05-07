package com.ftn.Taverna.web.kontroleri.DTO;


import com.ftn.Taverna.model.Akcija;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

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
