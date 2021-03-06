package com.ftn.Taverna.web.kontroleri.DTO.post;

import com.ftn.Taverna.model.Artikal;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ArtikalDTOPost implements Serializable {

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




    public ArtikalDTOPost(Artikal artikal){
        this.id = artikal.getId();
        this.naziv = artikal.getNaziv();
        this.opis = artikal.getOpis();
        this.cena = artikal.getCena();
        this.putanjaDoSlike = artikal.getPutanjaDoSlike();

    }


}
