package com.ftn.Taverna.web.kontroleri.DTO.post;

import com.ftn.Taverna.model.Artikal;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ArtikalEditDTO implements Serializable {

    @NotBlank
    private String naziv;
    @NotBlank
    private String opis;
    @NotBlank
    private Double cena;

    public ArtikalEditDTO(Artikal artikal){
        this.naziv = artikal.getNaziv();
        this.opis = artikal.getOpis();
        this.cena = artikal.getCena();
    }

}