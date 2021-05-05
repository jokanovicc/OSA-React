package com.ftn.Taverna.kontroleri;


import com.ftn.Taverna.model.*;
import com.ftn.Taverna.model.DTO.*;
import com.ftn.Taverna.model.DTO.post.KupacDTOPost;
import com.ftn.Taverna.model.DTO.post.ProdavacDTOPost;
import com.ftn.Taverna.servisi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private KorisnikServis korisnikServis;


    //CRUD operacije za kupca

    @PreAuthorize("hasAnyRole('ADMIN','PRODAVAC')")
    @RequestMapping(value = "/lista-kupaca", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<KupacDTOPost>> findAllKupac() {
        List<Kupac> kupci = kupacServis.findAll();
        List<KupacDTOPost> kupciDTO = new ArrayList<>();
        for(Kupac k: kupci){
            kupciDTO.add(new KupacDTOPost(k));
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


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value ="/lista-kupaca", consumes = "application/json")
    public ResponseEntity<KupacDTO> snimiKupca(@RequestBody KupacDTOPost kupacDTO){

        Korisnik noviKorisnik = new Korisnik();
        Kupac noviKupac = new Kupac();


        noviKorisnik.setKorisnicko(kupacDTO.getKorisnicko());
        noviKorisnik.setSifra(kupacDTO.getSifra());
        noviKorisnik.setIme(kupacDTO.getIme());
        noviKorisnik.setPrezime(kupacDTO.getPrezime());
        noviKorisnik.setBlokiran(false);
        noviKorisnik.setRoles(Roles.KUPAC);

        korisnikServis.save(noviKorisnik);


        noviKupac.setKorisnik(noviKorisnik);
        noviKupac.setId(noviKorisnik.getId());
        noviKupac.setAdresa(kupacDTO.getAdresa());

        noviKupac = kupacServis.saveKupac(noviKupac);
        return new ResponseEntity<KupacDTO>(new KupacDTO(noviKupac), HttpStatus.CREATED);

    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value ="/lista-kupaca",consumes = "application/json")
    public ResponseEntity<KupacDTOPost> izmeniKupca(@RequestBody KupacDTOPost kupacDTO){
        Kupac kupac = kupacServis.findOne(kupacDTO.getId());
        if(kupac == null){
            return new ResponseEntity<KupacDTOPost>(HttpStatus.BAD_REQUEST);
        }

        kupac.getKorisnik().setKorisnicko(kupacDTO.getKorisnicko());
        kupac.getKorisnik().setSifra(kupacDTO.getSifra());
        kupac.getKorisnik().setIme(kupacDTO.getIme());
        kupac.getKorisnik().setPrezime(kupacDTO.getPrezime());
        kupac.setAdresa(kupacDTO.getAdresa());


        kupacServis.saveKupac(kupac);
        return new ResponseEntity<KupacDTOPost>(new KupacDTOPost(kupac), HttpStatus.CREATED);



    }

    @PreAuthorize("hasAnyRole('ADMIN')")
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
    public ResponseEntity<ProdavacDTOPost> snimiProdavca(@RequestBody ProdavacDTOPost prodavacDTO){

        Korisnik noviKorisnik = new Korisnik();
        Prodavac noviProdavac = new Prodavac();


        noviKorisnik.setKorisnicko(prodavacDTO.getKorisnicko());
        noviKorisnik.setSifra(prodavacDTO.getSifra());
        noviKorisnik.setIme(prodavacDTO.getIme());
        noviKorisnik.setPrezime(prodavacDTO.getPrezime());
        noviKorisnik.setBlokiran(false);
        noviKorisnik.setRoles(Roles.KUPAC);

        korisnikServis.save(noviKorisnik);


        noviProdavac.setKorisnik(noviKorisnik);
        noviProdavac.setId(noviKorisnik.getId());
        noviProdavac.setAdresa(prodavacDTO.getAdresa());
        noviProdavac.setNaziv(prodavacDTO.getNaziv());
        noviProdavac.setImejl(prodavacDTO.getImejl());
        noviProdavac.setPoslujeOd(prodavacDTO.getPoslujeOd());

        noviProdavac = prodavacServis.saveProdavac(noviProdavac);
        return new ResponseEntity<ProdavacDTOPost>(new ProdavacDTOPost(noviProdavac), HttpStatus.CREATED);

    }



    @PutMapping(value ="/lista-prodavaca",consumes = "application/json")
    public ResponseEntity<ProdavacDTOPost> izmeniProdavca(@RequestBody ProdavacDTOPost prodavacDTO){
        Prodavac prodavac = prodavacServis.findOne(prodavacDTO.getId());
        if(prodavac == null){
            return new ResponseEntity<ProdavacDTOPost>(HttpStatus.BAD_REQUEST);
        }
        prodavac.getKorisnik().setIme(prodavacDTO.getIme());
        prodavac.getKorisnik().setPrezime(prodavacDTO.getPrezime());
        prodavac.setAdresa(prodavacDTO.getAdresa());
        prodavac.getKorisnik().setKorisnicko(prodavacDTO.getKorisnicko());
        prodavac.getKorisnik().setSifra(prodavacDTO.getSifra());

        prodavac.setPoslujeOd(prodavacDTO.getPoslujeOd());
        prodavac.setImejl(prodavacDTO.getImejl());
        prodavac.setNaziv(prodavacDTO.getNaziv());

        prodavacServis.saveProdavac(prodavac);
        return new ResponseEntity<ProdavacDTOPost>(new ProdavacDTOPost(prodavac), HttpStatus.CREATED);



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

    @PutMapping(value = "/blokiranje/{id}")
    public ResponseEntity<Void> blokirajKorisnika(@PathVariable("id") Integer id){
        Korisnik korisnik = korisnikServis.findOne(id);
        if(korisnik!=null){
            korisnik.setBlokiran(true);
            korisnikServis.save(korisnik);
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


