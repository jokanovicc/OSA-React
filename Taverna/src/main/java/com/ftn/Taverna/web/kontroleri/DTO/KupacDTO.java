package com.ftn.Taverna.web.kontroleri.DTO;

import com.ftn.Taverna.model.Kupac;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class KupacDTO implements Serializable {

    private Integer id;
    @NotBlank
    private String adresa;
    private KorisnikDTO korisnik;

    public KupacDTO(Kupac kupac){
        this.setId(kupac.getId());
        this.setAdresa(kupac.getAdresa());
        this.korisnik = new KorisnikDTO(kupac.getKorisnik());

    }



}
