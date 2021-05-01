package com.ftn.Taverna.model.DTO;

import com.ftn.Taverna.model.Kupac;
import com.ftn.Taverna.model.Prodavac;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
public class ProdavacDTO extends KorisnikAbstractDTO implements Serializable {

    @NotNull
    private Date poslujeOd;
    @NotBlank
    private String imejl;
    @NotBlank
    private String adresa;
    @NotBlank
    private String naziv;




    public ProdavacDTO(Prodavac prodavac){
        this.setId(prodavac.getId());
        this.setIme(prodavac.getIme());
        this.setPrezime(prodavac.getPrezime());
        this.setAdresa(prodavac.getAdresa());
        this.setKorisnicko(prodavac.getKorisnicko());
        this.setBlokiran(prodavac.isBlokiran());
        this.setSifra(prodavac.getSifra());
        this.setPoslujeOd(prodavac.getPoslujeOd());
        this.setImejl(prodavac.getImejl());
        this.setNaziv(prodavac.getNaziv());


    }

}
