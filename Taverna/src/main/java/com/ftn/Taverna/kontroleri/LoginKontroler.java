package com.ftn.Taverna.kontroleri;

import com.ftn.Taverna.model.DTO.KorisnikDTO;
import com.ftn.Taverna.model.Korisnik;
import com.ftn.Taverna.security.TokenUtils;
import com.ftn.Taverna.servisi.KorisnikServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class LoginKontroler {

    @Autowired
    KorisnikServis korisnikServis;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;




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
                new UsernamePasswordAuthenticationToken(userDto.getKorisnicko(), userDto.getSifra());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getKorisnicko());
            return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
