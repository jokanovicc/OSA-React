package com.ftn.Taverna.kontroleri;


import com.ftn.Taverna.model.DTO.KupacDTO;
import com.ftn.Taverna.model.DTO.ProdavacDTO;
import com.ftn.Taverna.model.Kupac;
import com.ftn.Taverna.model.Prodavac;
import com.ftn.Taverna.servisi.KupacServis;
import com.ftn.Taverna.servisi.ProdavacServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/korisnici")
@CrossOrigin("*")

public class KorisniciKontroler {

    @Autowired
    private KupacServis kupacServis;
    @Autowired
    private ProdavacServis prodavacServis;


    @RequestMapping(value = "/lista-kupaca", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<KupacDTO>> findAllKupac() {
        List<Kupac> kupci = kupacServis.findAll();
        List<KupacDTO> kupciDTO = new ArrayList<>();
        for(Kupac k: kupci){
            kupciDTO.add(new KupacDTO(k));
        }
        return new ResponseEntity<>(kupciDTO, HttpStatus.OK);


    }
    @RequestMapping(value = "/lista-prodavaca", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ProdavacDTO>> findAllProdavci() {
        List<Prodavac> prodavci = prodavacServis.findAll();
        List<ProdavacDTO> prodavacDTO = new ArrayList<>();
        for(Prodavac p:prodavci){
            prodavacDTO.add(new ProdavacDTO(p));
        }
        return new ResponseEntity<>(prodavacDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/lista-kupaca/{id}")
    public ResponseEntity<KupacDTO> getKupacById(@PathVariable("id") Integer id){
            Kupac kupac = kupacServis.findOne(id);
            if(kupac == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
            return new ResponseEntity<>(new KupacDTO(kupac), HttpStatus.OK);
        }



    @GetMapping(value = "/lista-prodavaca/{id}")
    public ResponseEntity<ProdavacDTO> getProdavacById(@PathVariable("id") Integer id){
        Prodavac prodavac = prodavacServis.findOne(id);
        if(prodavac == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(new ProdavacDTO(prodavac), HttpStatus.OK);
    }





        }


