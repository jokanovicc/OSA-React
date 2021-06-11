package com.ftn.Taverna.web.kontroleri.DTO.post;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnonimniKomentarDTO {

    @NotNull
    private Integer id;

    @NotBlank
    private String komentar;

    @NotEmpty
    private boolean anonimanKomentar;

    @NotEmpty
    private Integer ocena;
}
