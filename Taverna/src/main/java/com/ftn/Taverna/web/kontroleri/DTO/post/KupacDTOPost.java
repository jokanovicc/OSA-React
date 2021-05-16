package com.ftn.Taverna.web.kontroleri.DTO.post;

import com.ftn.Taverna.model.Kupac;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class KupacDTOPost {

    @NotEmpty
    private Integer id;
    @NotBlank
    private String adresa;
    @NotBlank
    private String ime;
    @NotBlank
    private String prezime;
    private String username;
    private String password;
    @NotBlank
    private boolean blokiran;


    public KupacDTOPost(Kupac kupac){
        this.setId(kupac.getId());
        this.setAdresa(kupac.getAdresa());
        this.ime = kupac.getKorisnik().getIme();
        this.prezime = kupac.getKorisnik().getPrezime();
        this.username = kupac.getKorisnik().getUsername();
        this.password = kupac.getKorisnik().getPassword();
        this.blokiran = kupac.getKorisnik().isBlokiran();

    }
}
