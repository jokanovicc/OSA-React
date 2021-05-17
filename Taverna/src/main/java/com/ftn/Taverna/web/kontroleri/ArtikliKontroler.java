package com.ftn.Taverna.web.kontroleri;

import com.ftn.Taverna.model.Akcija;
import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.web.kontroleri.DTO.AkcijaDTO;
import com.ftn.Taverna.web.kontroleri.DTO.ArtikalDTO;
import com.ftn.Taverna.web.kontroleri.DTO.post.AkcijaDTOPost;
import com.ftn.Taverna.web.kontroleri.DTO.post.ArtikalDTOPost;
import com.ftn.Taverna.model.Prodavac;
import com.ftn.Taverna.servisi.AkcijaServis;
import com.ftn.Taverna.servisi.ArtikliServis;
import com.ftn.Taverna.servisi.ProdavacServis;
import com.ftn.Taverna.web.kontroleri.DTO.post.ArtikalEditDTO;
import com.ftn.Taverna.web.kontroleri.DTO.post.v2.ArtikliPostmanPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    @Autowired
    private AkcijaServis akcijaServis;




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

    @GetMapping(value = "/artikli-prodavac")
    public ResponseEntity<Collection<ArtikalDTO>> findAllArtikliKorisnika(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        String username = userPrincipal.getUsername();
        System.out.println("Ovo jeee" + username);
        Prodavac prodavac = prodavacServis.getProdavacByUsername(username);

        List<Artikal> artikli = artikliServis.findByProdavac(prodavac.getId());
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


    @PreAuthorize("hasAnyRole('ADMIN','PRODAVAC')")
    @PostMapping
    public ResponseEntity<ArtikalDTO> snimiArtikal(@RequestBody ArtikalDTOPost artikalDTO, Authentication authentication){

        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        String username = userPrincipal.getUsername();
        System.out.println("Ovo jeee" + username);
        Prodavac prodavac = prodavacServis.getProdavacByUsername(username);

        Artikal artikal = new Artikal();
        artikal.setNaziv(artikalDTO.getNaziv());
        artikal.setCena(artikalDTO.getCena());
        artikal.setOpis(artikalDTO.getOpis());
        artikal.setPutanjaDoSlike(artikalDTO.getPutanjaDoSlike());
        artikal.setProdavac(prodavac);


        artikal = artikliServis.saveArtikal(artikal);
        return new ResponseEntity<ArtikalDTO>(new ArtikalDTO(artikal), HttpStatus.CREATED);


    }


    @PreAuthorize("hasAnyRole('ADMIN','PRODAVAC')")
    @PostMapping("dodavanje-artikla")
        public ResponseEntity<ArtikalDTO> snimiArtikal2(@RequestBody ArtikliPostmanPost artikalDTO){


        Prodavac prodavac = prodavacServis.findOne(artikalDTO.getProdavac());
        if(prodavac == null){
            return new ResponseEntity<ArtikalDTO>(HttpStatus.BAD_REQUEST);
        }


        Artikal artikal = new Artikal();
        artikal.setProdavac(prodavac);
        artikal.setNaziv(artikalDTO.getNaziv());
        artikal.setCena(artikalDTO.getCena());
        artikal.setOpis(artikalDTO.getOpis());
        artikal.setPutanjaDoSlike(artikalDTO.getPutanjaDoSlike());
        artikal.setProdavac(prodavac);


        artikal = artikliServis.saveArtikal(artikal);
        return new ResponseEntity<ArtikalDTO>(new ArtikalDTO(artikal), HttpStatus.CREATED);


    }


    @PreAuthorize("hasAnyRole('ADMIN','PRODAVAC')")
    @PutMapping("/{id}")
    public ResponseEntity<ArtikalDTO> izmeniArtikal(@PathVariable("id") Integer id,@RequestBody ArtikalEditDTO artikalDTO){
        Artikal artikal = artikliServis.findOne(id);
        if(artikal == null){
            return new ResponseEntity<ArtikalDTO>(HttpStatus.BAD_REQUEST);
        }
        artikal.setNaziv(artikalDTO.getNaziv());
        artikal.setCena(artikalDTO.getCena());
        artikal.setOpis(artikalDTO.getOpis());
        artikliServis.saveArtikal(artikal);
        return new ResponseEntity<>(new ArtikalDTO(artikal), HttpStatus.CREATED);


    }




    @PreAuthorize("hasAnyRole('ADMIN','PRODAVAC')")
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

    @PreAuthorize("hasAnyRole('ADMIN','PRODAVAC')")
    @PostMapping(value = "/lista-akcija")
    public ResponseEntity<AkcijaDTO> saveAkcija(@RequestBody AkcijaDTOPost akcijaDTOPost){
        Akcija akcija = new Akcija();
        Prodavac prodavac = prodavacServis.findOne(akcijaDTOPost.getProdavac());
        akcija.setProdavac(prodavac);
        akcija.setDoKad(akcijaDTOPost.getDoKad());
        akcija.setOdKad(akcijaDTOPost.getOdKad());
        akcija.setTekst(akcijaDTOPost.getTekst());
        akcija.setProcenat(akcijaDTOPost.getProcenat());
        akcija = akcijaServis.saveAkcija(akcija);

        return new ResponseEntity<AkcijaDTO>(new AkcijaDTO(akcija), HttpStatus.CREATED);



    }


    //sluzi samo da izlista akcije
    //METODE ZA AKCIJU
    @GetMapping("/lista-akcija")
    public ResponseEntity<Collection<AkcijaDTO>> findAllAkcije(){
        List<Akcija> akcije = akcijaServis.findAll();
        List<AkcijaDTO> akcijaDTO = new ArrayList<>();
        for(Akcija a: akcije){
            akcijaDTO.add(new AkcijaDTO(a));
        }
        return new ResponseEntity<>(akcijaDTO, HttpStatus.OK);



    }



    @GetMapping("/artikli-na-akciji")
    public ResponseEntity<Collection<ArtikalDTO>> findArtikliNaAkciji(){
        List<Akcija> akcije = akcijaServis.findAll();
        List<Artikal> artikli = new ArrayList<>();
        List<ArtikalDTO> artikalDTOS = new ArrayList<>();
        for(Akcija a: akcije){
            for(Artikal artikal: a.getArtikli()){
                artikli.add(artikal);
            }
        }

        for (Artikal a: artikli){
            artikalDTOS.add(new ArtikalDTO(a));
        }

        return new ResponseEntity<>(artikalDTOS, HttpStatus.OK);

    }





}
