package com.ftn.Taverna.kontroleri;

import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.DTO.ArtikalDTO;
import com.ftn.Taverna.model.DTO.KupacDTO;
import com.ftn.Taverna.model.Kupac;
import com.ftn.Taverna.servisi.ArtikliServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/artikli")
@CrossOrigin("*")
public class ArtikliKontroler {


    @Autowired
    private ArtikliServis artikliServis;


    @RequestMapping(value = "/lista-artikala", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ArtikalDTO>> findAllKupac() {
        List<Artikal> artikli = artikliServis.findAll();
        List<ArtikalDTO> artikliDTO = new ArrayList<>();
        for(Artikal a: artikli){
            artikliDTO.add(new ArtikalDTO(a));
        }
        return new ResponseEntity<>(artikliDTO, HttpStatus.OK);


    }

    @GetMapping(value = "/lista-artikala/{id}")
    public ResponseEntity<ArtikalDTO> getKupacById(@PathVariable("id") Integer id){
        Artikal artikal = artikliServis.findOne(id);
        if(artikal == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(new ArtikalDTO(artikal), HttpStatus.OK);
    }

}
