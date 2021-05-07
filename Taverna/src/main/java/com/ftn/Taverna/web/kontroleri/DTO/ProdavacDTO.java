package com.ftn.Taverna.web.kontroleri.DTO;

import com.ftn.Taverna.model.Prodavac;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
public class ProdavacDTO implements Serializable {

    private Integer id;
    @NotNull
    private Date poslujeOd;
    @NotBlank
    private String imejl;
    @NotBlank
    private String adresa;
    @NotBlank
    private String naziv;
    @NotNull
    private KorisnikDTO korisnik;


    public ProdavacDTO(Prodavac prodavac){
        this.id = prodavac.getId();
        this.setKorisnik(new KorisnikDTO(prodavac.getKorisnik()));
        this.setAdresa(prodavac.getAdresa());
        this.setPoslujeOd(prodavac.getPoslujeOd());
        this.setImejl(prodavac.getImejl());
        this.setNaziv(prodavac.getNaziv());


    }

}
