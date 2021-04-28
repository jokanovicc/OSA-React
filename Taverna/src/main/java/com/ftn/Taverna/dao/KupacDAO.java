package com.ftn.Taverna.dao;

import com.ftn.Taverna.model.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KupacDAO extends JpaRepository<Kupac, Integer> {
}
