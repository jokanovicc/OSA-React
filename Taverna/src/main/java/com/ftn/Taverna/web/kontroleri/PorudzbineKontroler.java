package com.ftn.Taverna.web.kontroleri;


import com.ftn.Taverna.web.kontroleri.DTO.PorudzbinaDTO;
import com.ftn.Taverna.web.kontroleri.DTO.post.PorudzbinaDTOPost;
import com.ftn.Taverna.model.Kupac;
import com.ftn.Taverna.model.Porudzbina;
import com.ftn.Taverna.servisi.KupacServis;
import com.ftn.Taverna.servisi.PorudzbinaServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/porudzbine")
@CrossOrigin("*")
public class PorudzbineKontroler {

    @Autowired
    private PorudzbinaServis porudzbinaServis;

    @Autowired
    private KupacServis kupacServis;


    @GetMapping
    public ResponseEntity<Collection<PorudzbinaDTO>> findAllPorudzbine() {
        List<Porudzbina> porudzbine = porudzbinaServis.findAll();
        List<PorudzbinaDTO> porudzbineDTO = new ArrayList<>();
        for(Porudzbina p:porudzbine){
            porudzbineDTO.add(new PorudzbinaDTO(p));
        }
        return new ResponseEntity<>(porudzbineDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<PorudzbinaDTO> getPorudzbinaById(@PathVariable("id") Integer id){
        Porudzbina porudzbina = porudzbinaServis.findOne(id);
        if(porudzbina == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(new PorudzbinaDTO(porudzbina), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PorudzbinaDTO> snimiPorudzbinu(@RequestBody PorudzbinaDTOPost porudzbinaDTO){
        Porudzbina porudzbina = new Porudzbina();
        porudzbina.setDostavljeno(porudzbinaDTO.isDostavljeno());
        porudzbina.setAnonimanKomentar(porudzbinaDTO.isAnonimanKomentar());
        porudzbina.setArhiviranKomentar(porudzbinaDTO.isArhiviranKomentar());
        porudzbina.setKomentar(porudzbinaDTO.getKomentar());
        porudzbina.setOcena(porudzbinaDTO.getOcena());
        porudzbina.setSatnica(porudzbinaDTO.getSatnica());

        Kupac kupac = kupacServis.findOne(porudzbinaDTO.getKupac());
        if(kupac == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        porudzbina.setKupac(kupac);
        porudzbina = porudzbinaServis.save(porudzbina);
        return new ResponseEntity<PorudzbinaDTO>(new PorudzbinaDTO(porudzbina),HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<PorudzbinaDTO> izmeniPorudzbinu(@RequestBody PorudzbinaDTOPost porudzbinaDTO){
        Porudzbina porudzbina = porudzbinaServis.findOne(porudzbinaDTO.getId());
        if(porudzbina == null){
            return new ResponseEntity<PorudzbinaDTO>(HttpStatus.BAD_REQUEST);

        }

        porudzbina.setDostavljeno(porudzbinaDTO.isDostavljeno());
        porudzbina.setAnonimanKomentar(porudzbinaDTO.isAnonimanKomentar());
        porudzbina.setArhiviranKomentar(porudzbinaDTO.isArhiviranKomentar());
        porudzbina.setKomentar(porudzbinaDTO.getKomentar());
        porudzbina.setOcena(porudzbinaDTO.getOcena());
        porudzbina.setSatnica(porudzbinaDTO.getSatnica());

        Kupac kupac = kupacServis.findOne(porudzbinaDTO.getKupac());
        if(kupac == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        porudzbina.setKupac(kupac);
        return new ResponseEntity<PorudzbinaDTO>(new PorudzbinaDTO(porudzbina),HttpStatus.CREATED);


    }

    @PreAuthorize("hasAnyRole('ADMIN','KUPAC')")
    @PutMapping("dodaj-komentar")
    public ResponseEntity<Void> dodajKomentar(@RequestBody PorudzbinaDTOPost porudzbinaDTOPost){
        Porudzbina porudzbina = porudzbinaServis.findOne(porudzbinaDTOPost.getId());
        if(porudzbina.isDostavljeno()){
            porudzbina.setKomentar(porudzbinaDTOPost.getKomentar());
            porudzbina.setOcena(porudzbinaDTOPost.getOcena());
            porudzbina = porudzbinaServis.save(porudzbina);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        }

    }
    @PreAuthorize("hasAnyRole('ADMIN','PRODAVAC')")
    @PutMapping("{id}/arhiviraj-komentar")
    public ResponseEntity<Void> dodajKomentar(@PathVariable("id") Integer id) {
        Porudzbina porudzbina = porudzbinaServis.findOne(id);
        if(porudzbina!=null){
            porudzbina.setArhiviranKomentar(true);
            porudzbinaServis.save(porudzbina);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        }



    }

}