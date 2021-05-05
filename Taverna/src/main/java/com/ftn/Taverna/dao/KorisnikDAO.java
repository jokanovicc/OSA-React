package com.ftn.Taverna.dao;

import com.ftn.Taverna.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KorisnikDAO extends JpaRepository<Korisnik, Integer> {

    Optional<Korisnik> findFirstByKorisnicko(String username);
}
