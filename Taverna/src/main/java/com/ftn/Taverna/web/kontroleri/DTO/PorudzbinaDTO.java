package com.ftn.Taverna.web.kontroleri.DTO;


import com.ftn.Taverna.model.Porudzbina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PorudzbinaDTO implements Serializable {


    @NotEmpty
    private Integer id;
    @NotNull
    private String kupac;

    @NotNull
    private Date satnica;

    @NotEmpty
    private boolean dostavljeno;

    @NotEmpty
    private Integer ocena;

    @NotBlank
    private String komentar;

    @NotEmpty
    private boolean anonimanKomentar;

    @NotEmpty
    private boolean arhiviranKomentar;
    
    
    
    public PorudzbinaDTO(Porudzbina porudzbina){
        this.kupac = porudzbina.getKupac().getKorisnik().getUsername();
        this.satnica = porudzbina.getSatnica();
        this.dostavljeno = porudzbina.isDostavljeno();
        this.ocena = porudzbina.getOcena();
        this.anonimanKomentar = porudzbina.isAnonimanKomentar();
        this.anonimanKomentar = porudzbina.isAnonimanKomentar();
    }


}
