package com.ftn.Taverna.servisi;

import com.ftn.Taverna.dao.AkcijaDAO;
import com.ftn.Taverna.model.Akcija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AkcijaServis {

    @Autowired
    private AkcijaDAO akcijaDAO;

    public List<Akcija> findAll(){
        return akcijaDAO.findAll();
    }

    public Akcija saveAkcija(Akcija akcija){
        return akcijaDAO.save(akcija);
    }
}
