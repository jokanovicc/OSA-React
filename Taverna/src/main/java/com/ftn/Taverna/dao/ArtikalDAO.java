package com.ftn.Taverna.dao;

import com.ftn.Taverna.model.Artikal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtikalDAO extends JpaRepository<Artikal, Integer> {

    List<Artikal> findByProdavac_Id(Integer id);

}
