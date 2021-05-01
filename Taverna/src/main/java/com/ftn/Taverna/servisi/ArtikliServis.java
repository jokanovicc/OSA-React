package com.ftn.Taverna.servisi;

import com.ftn.Taverna.dao.ArtikalDAO;
import com.ftn.Taverna.model.Artikal;
import com.ftn.Taverna.model.DTO.ArtikalDTO;
import com.ftn.Taverna.model.Kupac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikliServis {

    @Autowired
    private ArtikalDAO artikalDAO;

    public List<Artikal> findAll(){
        return artikalDAO.findAll();
    }

    public Artikal findOne(Integer id){
        return artikalDAO.findById(id).orElse(null);
    }

    public Artikal saveArtikal(Artikal artikal){
        return artikalDAO.save(artikal);
    }

    public void deleteArtikal(Artikal artikal){
        artikalDAO.delete(artikal);
    }

    public List<Artikal> findByProdavac(Integer id){
        return artikalDAO.findByProdavac_Id(id);
    }
}
