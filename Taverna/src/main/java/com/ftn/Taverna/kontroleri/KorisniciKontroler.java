package com.ftn.Taverna.kontroleri;


import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.DTO.ArtikalDTO;
import com.ftn.Taverna.model.DTO.KupacDTO;
import com.ftn.Taverna.model.DTO.PorudzbinaDTO;
import com.ftn.Taverna.model.DTO.ProdavacDTO;
import com.ftn.Taverna.model.Kupac;
import com.ftn.Taverna.model.Porudzbina;
import com.ftn.Taverna.model.Prodavac;
import com.ftn.Taverna.servisi.ArtikliServis;
import com.ftn.Taverna.servisi.KupacServis;
import com.ftn.Taverna.servisi.PorudzbinaServis;
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
    @Autowired
    private ArtikliServis artikliServis;
    @Autowired
    private PorudzbinaServis porudzbinaServis;


    //CRUD operacije za kupca

    @RequestMapping(value = "/lista-kupaca", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<KupacDTO>> findAllKupac() {
        List<Kupac> kupci = kupacServis.findAll();
        List<KupacDTO> kupciDTO = new ArrayList<>();
        for(Kupac k: kupci){
            kupciDTO.add(new KupacDTO(k));
        }
        return new ResponseEntity<>(kupciDTO, HttpStatus.OK);


    }

    @GetMapping(value = "/lista-kupaca/{id}")
    public ResponseEntity<KupacDTO> getKupacById(@PathVariable("id") Integer id){
            Kupac kupac = kupacServis.findOne(id);
            if(kupac == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
            return new ResponseEntity<>(new KupacDTO(kupac), HttpStatus.OK);
        }





    @PostMapping(value ="/lista-kupaca", consumes = "application/json")
    public ResponseEntity<KupacDTO> snimiKupca(@RequestBody KupacDTO kupacDTO){

        Kupac kupac = new Kupac();
        kupac.setIme(kupacDTO.getIme());
        kupac.setPrezime(kupacDTO.getPrezime());
        kupac.setAdresa(kupacDTO.getAdresa());
        kupac.setKorisnicko(kupacDTO.getKorisnicko());
        kupac.setSifra(kupacDTO.getSifra());
        kupac.setBlokiran(false);

        kupac = kupacServis.saveKupac(kupac);
        return new ResponseEntity<KupacDTO>(new KupacDTO(kupac), HttpStatus.CREATED);

    }



    @PutMapping(value ="/lista-kupaca",consumes = "application/json")
    public ResponseEntity<KupacDTO> izmeniKupca(@RequestBody KupacDTO kupacDTO){
        Kupac kupac = kupacServis.findOne(kupacDTO.getId());
        if(kupac == null){
            return new ResponseEntity<KupacDTO>(HttpStatus.BAD_REQUEST);
        }
        kupac.setIme(kupacDTO.getIme());
        kupac.setPrezime(kupacDTO.getPrezime());
        kupac.setAdresa(kupacDTO.getAdresa());
        kupac.setKorisnicko(kupacDTO.getKorisnicko());
        kupac.setSifra(kupacDTO.getSifra());

        kupacServis.saveKupac(kupac);
        return new ResponseEntity<KupacDTO>(new KupacDTO(kupac), HttpStatus.CREATED);



    }


    @DeleteMapping(value = "/lista-kupaca/{id}")
    public ResponseEntity<Void> obrisiKupca(@PathVariable("id") Integer id){
        Kupac kupac = kupacServis.findOne(id);
        if(kupac!=null){
            kupacServis.deleteKupac(kupac);
            return new ResponseEntity<Void>(HttpStatus.OK);

        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        }
    }


    //CRUD operacije za prodavca

    @RequestMapping(value = "/lista-prodavaca", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ProdavacDTO>> findAllProdavci() {
        List<Prodavac> prodavci = prodavacServis.findAll();
        List<ProdavacDTO> prodavacDTO = new ArrayList<>();
        for(Prodavac p:prodavci){
            prodavacDTO.add(new ProdavacDTO(p));
        }
        return new ResponseEntity<>(prodavacDTO, HttpStatus.OK);
    }



    @GetMapping(value = "/lista-prodavaca/{id}")
    public ResponseEntity<ProdavacDTO> getProdavacById(@PathVariable("id") Integer id){
        Prodavac prodavac = prodavacServis.findOne(id);
        if(prodavac == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(new ProdavacDTO(prodavac), HttpStatus.OK);
    }




    @PostMapping(value ="/lista-prodavaca", consumes = "application/json")
    public ResponseEntity<ProdavacDTO> snimiProdavca(@RequestBody ProdavacDTO prodavacDTO){

        Prodavac prodavac = new Prodavac();
        prodavac.setIme(prodavacDTO.getIme());
        prodavac.setPrezime(prodavacDTO.getPrezime());
        prodavac.setAdresa(prodavacDTO.getAdresa());
        prodavac.setKorisnicko(prodavacDTO.getKorisnicko());
        prodavac.setSifra(prodavacDTO.getSifra());
        prodavac.setPoslujeOd(prodavacDTO.getPoslujeOd());
        prodavac.setImejl(prodavacDTO.getImejl());
        prodavac.setNaziv(prodavacDTO.getNaziv());
        prodavac.setBlokiran(false);

        prodavac = prodavacServis.saveProdavac(prodavac);
        return new ResponseEntity<ProdavacDTO>(new ProdavacDTO(prodavac), HttpStatus.CREATED);

    }



    @PutMapping(value ="/lista-prodavaca",consumes = "application/json")
    public ResponseEntity<ProdavacDTO> izmeniProdavca(@RequestBody ProdavacDTO prodavacDTO){
        Prodavac prodavac = prodavacServis.findOne(prodavacDTO.getId());
        if(prodavac == null){
            return new ResponseEntity<ProdavacDTO>(HttpStatus.BAD_REQUEST);
        }
        prodavac.setIme(prodavacDTO.getIme());
        prodavac.setPrezime(prodavacDTO.getPrezime());
        prodavac.setAdresa(prodavacDTO.getAdresa());
        prodavac.setKorisnicko(prodavacDTO.getKorisnicko());
        prodavac.setSifra(prodavacDTO.getSifra());
        prodavac.setPoslujeOd(prodavacDTO.getPoslujeOd());
        prodavac.setImejl(prodavacDTO.getImejl());
        prodavac.setNaziv(prodavacDTO.getNaziv());

        prodavacServis.saveProdavac(prodavac);
        return new ResponseEntity<ProdavacDTO>(new ProdavacDTO(prodavac), HttpStatus.CREATED);



    }

    @DeleteMapping(value = "/lista-prodavaca/{id}")
    public ResponseEntity<Void> obrisiProdavca(@PathVariable("id") Integer id){
        Prodavac prodavac = prodavacServis.findOne(id);
        if(prodavac!=null){
            prodavacServis.deleteProdavac(prodavac);
            return new ResponseEntity<Void>(HttpStatus.OK);

        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        }
    }


    //FIND Artikli od prodavca naprimer
    @GetMapping(value = "/lista-prodavaca/{id}/lista-artikala")
    public ResponseEntity<Collection<ArtikalDTO>> findArtikleByProdavac(@PathVariable("id") Integer id){
        List<Artikal> artikli = artikliServis.findByProdavac(id);
        List<ArtikalDTO> artikliDTO = new ArrayList<>();
        for(Artikal a: artikli){
            artikliDTO.add(new ArtikalDTO(a));
        }
        return new ResponseEntity<>(artikliDTO,HttpStatus.OK);
    }


    //Blokiraj korisnika

    @PostMapping(value = "/lista-prodavaca/{id}")
    public ResponseEntity<Void> blokirajProdavca(@PathVariable("id") Integer id){
        Prodavac prodavac = prodavacServis.findOne(id);
        if(prodavac!=null){
            prodavac.setBlokiran(true);
            prodavacServis.saveProdavac(prodavac);
            return new ResponseEntity<Void>(HttpStatus.OK);

        }else{
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping(value = "/lista-kupaca/{id}")
    public ResponseEntity<Void> blokirajKupca(@PathVariable("id") Integer id){
        Kupac kupac = kupacServis.findOne(id);
        if(kupac!=null){
            kupac.setBlokiran(true);
            kupacServis.saveKupac(kupac);
            return new ResponseEntity<Void>(HttpStatus.OK);

        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        }

    }



    //sve porudzbine kupca
    @GetMapping(value = "/lista-kupaca/{id}/lista-porudzbina")
    public ResponseEntity<Collection<PorudzbinaDTO>> findPorudzbineByKupac(@PathVariable("id") Integer id){
        List<Porudzbina> porudzbine = porudzbinaServis.findByKupacId(id);
        List<PorudzbinaDTO> porudzbinaDTO = new ArrayList<>();
        for(Porudzbina p : porudzbine){
            porudzbinaDTO.add(new PorudzbinaDTO(p));
        }

        return new ResponseEntity<>(porudzbinaDTO, HttpStatus.OK);


    }


}


