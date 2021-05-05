package com.ftn.Taverna.servisi;

import com.ftn.Taverna.dao.KorisnikDAO;
import com.ftn.Taverna.model.DTO.KorisnikDTO;
import com.ftn.Taverna.model.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServis {

    @Autowired
    private KorisnikDAO korisnikDAO;



    public Korisnik save(Korisnik novKorisnik){
        return korisnikDAO.save(novKorisnik);
    }

    public Korisnik findOne(Integer id){
        return korisnikDAO.findById(id).orElse(null);
    }




}
