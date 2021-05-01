package com.ftn.Taverna.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Kupac extends KorisnikAbstract {
    private String adresa;
}
