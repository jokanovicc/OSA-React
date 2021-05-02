package com.ftn.Taverna.dao;

import com.ftn.Taverna.model.Akcija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AkcijaDAO extends JpaRepository<Akcija, Integer> {
}
