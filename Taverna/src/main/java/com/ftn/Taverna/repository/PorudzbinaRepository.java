package com.ftn.Taverna.repository;

import com.ftn.Taverna.model.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Integer> {

    List<Porudzbina> findPorudzbinaByKupac_Id(Integer id);




}
