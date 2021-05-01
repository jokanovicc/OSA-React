package com.ftn.Taverna.servisi;

import com.ftn.Taverna.dao.KupacDAO;
import com.ftn.Taverna.model.Kupac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KupacServis {

    @Autowired
    private KupacDAO kupacDAO;

    public List<Kupac> findAll(){
        return kupacDAO.findAll();
    }

    public Kupac findOne(Integer id){
        return kupacDAO.findById(id).orElse(null);
    }
}
