package com.ftn.Taverna.model.DTO;

import com.ftn.Taverna.model.Kupac;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class KupacDTO extends KorisnikAbstractDTO implements Serializable {

    private Integer id;
    @NotBlank
    private String adresa;

    public KupacDTO(Kupac kupac){
        this.setId(kupac.getId());
        this.setIme(kupac.getIme());
        this.setPrezime(kupac.getPrezime());
        this.setAdresa(kupac.getAdresa());
        this.setKorisnicko(kupac.getKorisnicko());
        this.setBlokiran(kupac.isBlokiran());
        this.setSifra(kupac.getSifra());


    }



}
