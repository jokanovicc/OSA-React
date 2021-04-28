package com.ftn.Taverna.kontroleri;


import com.ftn.Taverna.model.Kupac;
import com.ftn.Taverna.model.Prodavac;
import com.ftn.Taverna.servisi.KupacServis;
import com.ftn.Taverna.servisi.ProdavacServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/korisnici")
@CrossOrigin("*")

public class KorisniciKontroler {

    @Autowired
    private KupacServis kupacServis;
    @Autowired
    private ProdavacServis prodavacServis;


    @RequestMapping(value = "/lista-kupaca", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Kupac>> findAllKupac() {
        return new ResponseEntity<>(kupacServis.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/lista-prodavaca", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Prodavac>> findAllProdavci() {
        return new ResponseEntity<>(prodavacServis.findAll(), HttpStatus.OK);
    }

}
