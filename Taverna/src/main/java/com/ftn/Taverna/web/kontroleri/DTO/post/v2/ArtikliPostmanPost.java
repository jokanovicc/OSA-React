package com.ftn.Taverna.web.kontroleri.DTO.post.v2;

import com.ftn.Taverna.model.Artikal;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ArtikliPostmanPost implements Serializable {

    @NotEmpty
    private Integer id;
    @NotBlank
    private String naziv;
    @NotBlank
    private String opis;
    @NotBlank
    private Double cena;
    @NotBlank
    private String putanjaDoSlike;
    @NotBlank
    private Integer prodavac;




    public ArtikliPostmanPost(Artikal artikal){
        this.id = artikal.getId();
        this.naziv = artikal.getNaziv();
        this.opis = artikal.getOpis();
        this.cena = artikal.getCena();
        this.putanjaDoSlike = artikal.getPutanjaDoSlike();
        this.prodavac = artikal.getProdavac().getKorisnik().getId();

    }


}

