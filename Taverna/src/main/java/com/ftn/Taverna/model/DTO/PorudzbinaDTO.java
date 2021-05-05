package com.ftn.Taverna.model.DTO;


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
    private KupacDTO kupac;

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
        this(porudzbina.getId(), new KupacDTO(porudzbina.getKupac()), porudzbina.getSatnica(), porudzbina.isDostavljeno(), porudzbina.getOcena(), porudzbina.getKomentar(), porudzbina.isAnonimanKomentar(), porudzbina.isArhiviranKomentar());
    }


}
