package com.bogglebros.webapp.service;

import com.bogglebros.webapp.database.dao.RatDAO;
import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.formbean.CreateRatFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RatService {

    @Autowired
    private RatDAO ratDao;

    public Rat createRat(CreateRatFormBean form){
        log.debug("id: " + form.getId());
        log.debug("name: " + form.getName());
        log.info("genes: " + form.getGenes());
        log.info("adopterId: " + form.getAdopterId());
        log.info("adoptionStatus: " + form.getAdoptionStatus());
        log.info("sex: " + form.getSex());

        Rat rat = ratDao.findById(form.getId());

        if ( rat == null){
            rat = new Rat();
        }

        rat.setName(form.getName());
        rat.setGenes(form.getGenes());
        rat.setAdopterId(form.getAdopterId());
        rat.setAdoptionStatus(form.getAdoptionStatus());
        rat.setSex(form.getSex());

        return ratDao.save(rat);
    }
}