package com.ftn.Taverna.model.DTO;

import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.Porudzbina;
import com.ftn.Taverna.model.Stavka;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StavkaDTO implements Serializable {

    @NotEmpty
    private Integer id;

    @NotEmpty
    private Integer kolicina;

    @NotNull
    private ArtikalDTO artikal;
    @NotNull
    private PorudzbinaDTO porudzbina;

    public StavkaDTO(Stavka stavka) {
        this(stavka.getId(),stavka.getKolicina(),new ArtikalDTO(stavka.getArtikal()), new PorudzbinaDTO(stavka.getPorudzbina()));

    }


}
