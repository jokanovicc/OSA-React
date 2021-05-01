package com.ftn.Taverna.servisi;

import com.ftn.Taverna.dao.ProdavacDAO;
import com.ftn.Taverna.model.Kupac;
import com.ftn.Taverna.model.Prodavac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdavacServis {

    @Autowired
    private ProdavacDAO prodavacDAO;


    public List<Prodavac> findAll(){
        return prodavacDAO.findAll();
    }

    public Prodavac findOne(Integer id){
        return prodavacDAO.findById(id).orElse(null);
    }
}
