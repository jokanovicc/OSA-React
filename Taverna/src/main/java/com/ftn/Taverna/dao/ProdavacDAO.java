package com.ftn.Taverna.dao;

import com.ftn.Taverna.model.Prodavac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdavacDAO extends JpaRepository<Prodavac, Integer> {
}
