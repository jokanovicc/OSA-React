package com.ftn.Taverna.model.DTO;

import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.Prodavac;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@NoArgsConstructor
public class ArtikalDTO implements Serializable {

    private Integer id;

    @NotEmpty
    private Prodavac prodavac;
    @NotBlank
    private String naziv;
    @NotBlank
    private String opis;
    @NotBlank
    private Double cena;
    @NotBlank
    private String putanjaDoSlike;


    public ArtikalDTO(Artikal artikal){
        this.id = artikal.getId();
        this.prodavac = artikal.getProdavac();
        this.naziv = artikal.getNaziv();
        this.opis = artikal.getOpis();
        this.cena = artikal.getCena();
        this.putanjaDoSlike = artikal.getPutanjaDoSlike();

    }

}