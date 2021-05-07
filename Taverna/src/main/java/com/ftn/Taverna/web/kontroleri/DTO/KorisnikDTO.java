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
    @NotBlank
    private String korisnicko;
    @NotBlank
    private String sifra;
    @NotBlank
    private boolean blokiran;

    public KorisnikDTO(Korisnik korisnik){
        this.id = korisnik.getId();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.korisnicko = korisnik.getKorisnicko();
        this.sifra = korisnik.getSifra();
        this.blokiran = korisnik.isBlokiran();
    }


}
