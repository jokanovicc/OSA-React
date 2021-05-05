package com.ftn.Taverna.dao;

import com.ftn.Taverna.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikDAO extends JpaRepository<Korisnik, Integer> {
}
