package com.ftn.Taverna.repository;

import com.ftn.Taverna.model.Prodavac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdavacRepository extends JpaRepository<Prodavac, Integer> {

    Prodavac getProdavacByKorisnik_Username(String username);
}
