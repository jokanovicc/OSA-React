package com.ftn.Taverna.web.kontroleri.DTO;

import com.ftn.Taverna.model.Artikal;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@NoArgsConstructor
public class ArtikalDTO implements Serializable {

    @NotEmpty
    private Integer id;

    @NotNull
    private ProdavacDTO prodavac;
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
        this.prodavac = new ProdavacDTO(artikal.getProdavac());
        this.naziv = artikal.getNaziv();
        this.opis = artikal.getOpis();
        this.cena = artikal.getCena();
        this.putanjaDoSlike = artikal.getPutanjaDoSlike();


    }

}
