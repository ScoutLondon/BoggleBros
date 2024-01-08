package com.bogglebros.webapp.service;

import com.bogglebros.webapp.database.dao.RatDAO;
import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.formbean.CreateRatFormBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class RatService {

    @Autowired
    private RatDAO ratDao;

    public Rat createRat(CreateRatFormBean form) throws ParseException {
        log.debug("id: " + form.getId());
        log.debug("name: " + form.getName());
        log.info("genes: " + form.getGenes());
        log.info("birthday: " + form.getBirthday());
        log.info("price: " + form.getPrice());
        log.info("sex: " + form.getSex());
        log.info("ratStatus: " + form.getRatStatus());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(form.getBirthday());

        Rat rat = ratDao.findById(form.getId());


        if ( rat == null){
            rat = new Rat();
            log.debug("Existing rat not found, new rat created with ID: " + rat.getId());
        }

        //form.get
        if (!form.getPhoto1().isEmpty()) {
            File f1 = new File("./src/main/webapp/pub/images/" + form.getPhoto1().getOriginalFilename());
            try (OutputStream outputStream = new FileOutputStream(f1.getAbsolutePath())) {
                IOUtils.copy(form.getPhoto1().getInputStream(), outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //rat.set
            rat.setPhoto1("/pub/images/" + form.getPhoto1().getOriginalFilename());
        }

        if (!form.getPhoto2().isEmpty()) {
            File f2 = new File("./src/main/webapp/pub/images/" + form.getPhoto2().getOriginalFilename());
            try (OutputStream outputStream = new FileOutputStream(f2.getAbsolutePath())) {
                IOUtils.copy(form.getPhoto2().getInputStream(), outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rat.setPhoto2("/pub/images/" + form.getPhoto2().getOriginalFilename());
        }

        if (!form.getPhoto3().isEmpty()) {
            File f3 = new File("./src/main/webapp/pub/images/" + form.getPhoto3().getOriginalFilename());
            try (OutputStream outputStream = new FileOutputStream(f3.getAbsolutePath())) {
                IOUtils.copy(form.getPhoto3().getInputStream(), outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rat.setPhoto3("/pub/images/" + form.getPhoto3().getOriginalFilename());
        }

        rat.setName(form.getName());
        rat.setGenes(form.getGenes());
        rat.setBirthday(birthday);
        rat.setPrice(form.getPrice());
        rat.setSex(form.getSex());
        rat.setSize(form.getSize());
        rat.setRatStatus(form.getRatStatus());

        return ratDao.save(rat);
    }

    public Rat updateRat(CreateRatFormBean form) throws ParseException {
        log.debug("id: " + form.getId());
        log.debug("name: " + form.getName());
        log.info("genes: " + form.getGenes());
        log.info("birthday: " + form.getBirthday());
        log.info("price: " + form.getPrice());
        log.info("sex: " + form.getSex());
        log.info("ratStatus: " + form.getRatStatus());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(form.getBirthday());

        Rat rat = ratDao.findById(form.getId());


        //form.get
        if ((!form.getPhoto1().isEmpty()) && (rat.getPhoto1() != null)) {
            File f1 = new File("./src/main/webapp/pub/images/" + form.getPhoto1().getOriginalFilename());
            try (OutputStream outputStream = new FileOutputStream(f1.getAbsolutePath())) {
                IOUtils.copy(form.getPhoto1().getInputStream(), outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //rat.set
            rat.setPhoto1("/pub/images/" + form.getPhoto1().getOriginalFilename());
        }

        if ((!form.getPhoto2().isEmpty()) && (rat.getPhoto2() != null)) {
            File f2 = new File("./src/main/webapp/pub/images/" + form.getPhoto2().getOriginalFilename());
            try (OutputStream outputStream = new FileOutputStream(f2.getAbsolutePath())) {
                IOUtils.copy(form.getPhoto2().getInputStream(), outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rat.setPhoto2("/pub/images/" + form.getPhoto2().getOriginalFilename());
        }

        if ((!form.getPhoto3().isEmpty()) && (rat.getPhoto3() != null)) {
            File f3 = new File("./src/main/webapp/pub/images/" + form.getPhoto3().getOriginalFilename());
            try (OutputStream outputStream = new FileOutputStream(f3.getAbsolutePath())) {
                IOUtils.copy(form.getPhoto3().getInputStream(), outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rat.setPhoto3("/pub/images/" + form.getPhoto3().getOriginalFilename());
        }

        if(!rat.getName().equals(form.getName())) {
            rat.setName(form.getName());
        }
        if(!rat.getGenes().equals(form.getGenes())) {
            rat.setGenes(form.getGenes());
        }
        if(!rat.getBirthday().equals(birthday)) {
            rat.setBirthday(birthday);
        }
        if(rat.getPrice().intValue() == form.getPrice().intValue()) {
            rat.setPrice(form.getPrice());
        }
        if(!rat.getSex().equals(form.getSex())) {
            rat.setSex(form.getSex());
        }
        if(!rat.getSize().equals(form.getSize())) {
            rat.setSize(form.getSize());
        }
        if(!rat.getRatStatus().equals(form.getRatStatus())) {
            rat.setRatStatus(form.getRatStatus());
        }

        return ratDao.save(rat);
    }
}