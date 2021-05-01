package com.ftn.Taverna.kontroleri;

import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.DTO.ArtikalDTO;
import com.ftn.Taverna.model.DTO.post.ArtikalDTOPost;
import com.ftn.Taverna.model.Prodavac;
import com.ftn.Taverna.servisi.ArtikliServis;
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
@RequestMapping("/artikli")
@CrossOrigin("*")
public class ArtikliKontroler {


    @Autowired
    private ArtikliServis artikliServis;
    @Autowired
    private ProdavacServis prodavacServis;



    //CRUD OPERACIJE ARTIKLA
    @GetMapping
    public ResponseEntity<Collection<ArtikalDTO>> findAllArtikli() {
        List<Artikal> artikli = artikliServis.findAll();
        List<ArtikalDTO> artikliDTO = new ArrayList<>();
        for(Artikal a: artikli){
            artikliDTO.add(new ArtikalDTO(a));
        }
        return new ResponseEntity<>(artikliDTO, HttpStatus.OK);


    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ArtikalDTO> getArtikalById(@PathVariable("id") Integer id){
        Artikal artikal = artikliServis.findOne(id);
        if(artikal == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(new ArtikalDTO(artikal), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ArtikalDTO> snimiArtikal(@RequestBody ArtikalDTOPost artikalDTO){
        Artikal artikal = new Artikal();
        artikal.setNaziv(artikalDTO.getNaziv());
        artikal.setCena(artikalDTO.getCena());
        artikal.setOpis(artikalDTO.getOpis());
        artikal.setPutanjaDoSlike(artikal.getPutanjaDoSlike());
        System.out.println("aaaaaaaa " + artikalDTO.getProdavac());
        Prodavac prodavac = prodavacServis.findOne(artikalDTO.getProdavac());
        if(prodavac==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        artikal.setProdavac(prodavac);
        artikal = artikliServis.saveArtikal(artikal);
        return new ResponseEntity<ArtikalDTO>(new ArtikalDTO(artikal), HttpStatus.CREATED);


    }

    @PutMapping
    public ResponseEntity<ArtikalDTO> izmeniArtikal(@RequestBody ArtikalDTOPost artikalDTO){
        Artikal artikal = artikliServis.findOne(artikalDTO.getId());
        if(artikal == null){
            return new ResponseEntity<ArtikalDTO>(HttpStatus.BAD_REQUEST);

        }
        artikal.setNaziv(artikalDTO.getNaziv());
        artikal.setCena(artikalDTO.getCena());
        artikal.setOpis(artikalDTO.getOpis());
        artikal.setPutanjaDoSlike(artikal.getPutanjaDoSlike());
        System.out.println("aaaaaaaa " + artikalDTO.getProdavac());
        Prodavac prodavac = prodavacServis.findOne(artikalDTO.getProdavac());
        if(prodavac==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        artikal.setProdavac(prodavac);
        artikliServis.saveArtikal(artikal);
        return new ResponseEntity<>(new ArtikalDTO(artikal), HttpStatus.CREATED);


    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> obrisiArtikal(@PathVariable("id") Integer id){
        Artikal artikal = artikliServis.findOne(id);
        if(artikal!=null){
            artikliServis.deleteArtikal(artikal);
            return new ResponseEntity<Void>(HttpStatus.OK);

        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        }
    }





}
