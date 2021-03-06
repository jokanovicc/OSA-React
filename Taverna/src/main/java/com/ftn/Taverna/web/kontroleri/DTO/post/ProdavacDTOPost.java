package com.ftn.Taverna.web.kontroleri.DTO.post;

import com.ftn.Taverna.model.Prodavac;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;



@Data
@NoArgsConstructor
public class ProdavacDTOPost {


    @NotBlank
    private String ime;

    @NotBlank
    private String prezime;

    private String username;
    private String password;

    @NotBlank
    private boolean blokiran;

    @NotEmpty
    private Integer id;

    @NotNull
    private Date poslujeOd;

    @NotBlank
    private String imejl;

    @NotBlank
    private String adresa;

    @NotBlank
    private String naziv;


    public ProdavacDTOPost(Prodavac prodavac){
        this.id = prodavac.getId();
        this.setAdresa(prodavac.getAdresa());
        this.setPoslujeOd(prodavac.getPoslujeOd());
        this.setImejl(prodavac.getImejl());
        this.setNaziv(prodavac.getNaziv());
        this.ime = prodavac.getKorisnik().getIme();
        this.prezime = prodavac.getKorisnik().getPrezime();
        this.username = prodavac.getKorisnik().getUsername();
        this.password = prodavac.getKorisnik().getPassword();
        this.blokiran = prodavac.getKorisnik().isBlokiran();

    }
}
