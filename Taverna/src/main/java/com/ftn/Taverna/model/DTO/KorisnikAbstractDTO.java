package com.ftn.Taverna.model.DTO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
public abstract class KorisnikAbstractDTO {

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
}
