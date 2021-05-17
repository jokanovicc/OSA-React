package com.ftn.Taverna.web.kontroleri.DTO;

import com.ftn.Taverna.model.Porudzbina;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class NedostavljenePorudzbine {

    @NotEmpty
    private Integer id;
    @NotNull
    private Integer kupac;

    @NotNull
    private Date satnica;

    @NotEmpty
    private boolean dostavljeno;


    public NedostavljenePorudzbine(Porudzbina porudzbina){
        this.id = porudzbina.getId();
        this.kupac = porudzbina.getKupac().getKorisnik().getId();
        this.satnica = porudzbina.getSatnica();
        this.dostavljeno = porudzbina.isDostavljeno();
    }



}
