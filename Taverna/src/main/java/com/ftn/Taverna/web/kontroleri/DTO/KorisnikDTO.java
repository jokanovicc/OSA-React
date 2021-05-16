package com.ftn.Taverna.web.kontroleri.DTO;

import com.ftn.Taverna.model.Korisnik;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class KorisnikDTO {

    private Integer id;
    @NotBlank
    private String ime;
    @NotBlank
    private String prezime;
    private String username;
    private String password;
    @NotBlank
    private boolean blokiran;

    public KorisnikDTO(Korisnik korisnik){
        this.id = korisnik.getId();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.username= korisnik.getUsername();
        this.password = korisnik.getPassword();
        this.blokiran = korisnik.isBlokiran();
    }


}
