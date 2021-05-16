package com.ftn.Taverna.web.kontroleri;

import com.ftn.Taverna.repository.KorisnikRepository;
import com.ftn.Taverna.web.kontroleri.DTO.KorisnikDTO;
import com.ftn.Taverna.web.kontroleri.DTO.KupacDTO;
import com.ftn.Taverna.web.kontroleri.DTO.post.KupacDTOPost;
import com.ftn.Taverna.web.kontroleri.DTO.post.ProdavacDTOPost;
import com.ftn.Taverna.model.Korisnik;
import com.ftn.Taverna.model.Kupac;
import com.ftn.Taverna.model.Prodavac;
import com.ftn.Taverna.model.Roles;
import com.ftn.Taverna.security.TokenUtils;
import com.ftn.Taverna.servisi.KorisnikServis;
import com.ftn.Taverna.servisi.KupacServis;
import com.ftn.Taverna.servisi.ProdavacServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class LoginKontroler {

    @Autowired
    KorisnikServis korisnikServis;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    KupacServis kupacServis;
    @Autowired
    ProdavacServis prodavacServis;

    @Autowired
    KorisnikRepository korisnikRepository;




//    @PostMapping()
//    public ResponseEntity<KorisnikDTO> create(@RequestBody @Validated KorisnikDTO newUser){
//
//        Korisnik createdUser = korisnikServis.createUser(newUser);
//
//        if(createdUser == null){
//            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
//        }
//        UserDTO userDTO = new UserDTO(createdUser);
//
//        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
//    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody KorisnikDTO userDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("sam ovde_ ");
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());
            return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(value ="/registracija-kupac", consumes = "application/json")
    public ResponseEntity<KupacDTO> snimiKupca(@RequestBody @Validated KupacDTOPost kupacDTO){

        Optional<Korisnik> user = korisnikRepository.findFirstByUsername(kupacDTO.getUsername());
        if(user.isPresent()){
            return null;
        }

        Korisnik noviKorisnik = new Korisnik();
        Kupac noviKupac = new Kupac();


        noviKorisnik.setUsername(kupacDTO.getUsername());
        noviKorisnik.setPassword(passwordEncoder.encode(kupacDTO.getPassword()));
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


    @PostMapping(value ="/registracija-prodavac", consumes = "application/json")
    public ResponseEntity<ProdavacDTOPost> snimiProdavca(@RequestBody @Validated ProdavacDTOPost prodavacDTO){

        Optional<Korisnik> user = korisnikRepository.findFirstByUsername(prodavacDTO.getUsername());
        if(user.isPresent()){
            return null;
        }



        Korisnik noviKorisnik = new Korisnik();
        Prodavac noviProdavac = new Prodavac();


        noviKorisnik.setUsername(prodavacDTO.getUsername());
        noviKorisnik.setPassword(passwordEncoder.encode(prodavacDTO.getPassword()));
        noviKorisnik.setIme(prodavacDTO.getIme());
        noviKorisnik.setPrezime(prodavacDTO.getPrezime());
        noviKorisnik.setBlokiran(false);
        noviKorisnik.setRoles(Roles.PRODAVAC);

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



}
