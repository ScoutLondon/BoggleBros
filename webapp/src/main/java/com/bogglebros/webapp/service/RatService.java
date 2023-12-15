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
        log.info("birthday: " + form.getBirthday());
        log.info("price: " + form.getPrice());
        log.info("sex: " + form.getSex());
        log.info("ratStatus: " + form.getRatStatus());

        Rat rat = ratDao.findById(form.getId());

        if ( rat == null){
            rat = new Rat();
        }

        rat.setName(form.getName());
        rat.setGenes(form.getGenes());
        rat.setBirthday(form.getBirthday());
        rat.setPrice(form.getPrice());
        rat.setSex(form.getSex());
        rat.setSize(form.getSize());
        rat.setPhoto1(form.getPhoto1());
        rat.setPhoto2(form.getPhoto2());
        rat.setPhoto3(form.getPhoto3());
        rat.setRatStatus(form.getRatStatus());

        return ratDao.save(rat);
    }
}