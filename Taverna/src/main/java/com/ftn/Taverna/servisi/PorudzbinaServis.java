package com.ftn.Taverna.servisi;


import com.ftn.Taverna.repository.PorudzbinaRepository;
import com.ftn.Taverna.model.Porudzbina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorudzbinaServis {

    @Autowired
    private PorudzbinaRepository porudzbinaDAO;

    public List<Porudzbina> findAll(){
        return porudzbinaDAO.findAll();
    }

    public Porudzbina findOne(Integer id){
        return porudzbinaDAO.findById(id).orElse(null);
    }

    public Porudzbina save(Porudzbina porudzbina){
        return porudzbinaDAO.save(porudzbina);
    }

    public List<Porudzbina> findByKupacId(Integer id){
        return porudzbinaDAO.findPorudzbinaByKupac_Id(id);
    }

}
