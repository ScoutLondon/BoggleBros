package com.bogglebros.webapp.controller;

import com.bogglebros.webapp.database.dao.RatDAO;
import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.formbean.CreateRatFormBean;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import com.bogglebros.webapp.service.RatService;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;




import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Controller
public class RatController {

    @Autowired
    private RatService ratService;

    @Autowired
    private RatDAO ratDao;

    @GetMapping("/rat/create")
    public ModelAndView create(){
        ModelAndView response = new ModelAndView();
        response.setViewName("rat/create");
        return response;
    }

    @PostMapping("/rat/createSubmit")
    public ModelAndView createSubmit(@Valid CreateRatFormBean form, BindingResult bindingResult,HttpSession session) throws ParseException {

        if (bindingResult.hasErrors()) {
            log.info("######################### In create rat - has errors #########################");
            ModelAndView response = new ModelAndView("rat/create");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("############ In create rat - no error found #############");


        Rat r = ratService.createRat(form);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/");

        return response;
    }

    @GetMapping("/rat/available")
    public ModelAndView availableRats() {
        ModelAndView response = new ModelAndView("rat/available");
        log.info("In available rats with no args");
        List<Rat> rats = ratDao.findByRatStatus("Available");
        response.addObject("ratList", rats);
        for (Rat rat : rats){
            log.debug("Rat: id = " + rat.getId() + " Name = " + rat.getName());
        }
        return response;
    }

    @GetMapping("/rat/ratabase")
    public ModelAndView editRats() {
        ModelAndView response = new ModelAndView("rat/ratabase");
        log.info("In all rats with no args");
        List<Rat> rats = ratDao.findAllRats();
        response.addObject("ratList", rats);
        for (Rat rat : rats){
            log.debug("Rat: id = " + rat.getId() + " Name = " + rat.getName());
        }
        return response;
    }

    @GetMapping("/rat/edit/{id}")
    //use this for edit/id/x vs edit?id=x
    public ModelAndView editRat(@PathVariable int id){
        ModelAndView response = new ModelAndView("rat/edit");
        log.info("In edit rat with id: " + id);

        Rat rat = ratDao.findById(id);

        CreateRatFormBean form = new CreateRatFormBean();

        if ( rat != null) {
            form.setId(rat.getId());
            log.debug("form ID set to: " + form.getId());
            form.setName(rat.getName());
            form.setGenes(rat.getGenes());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedBirthday = sdf.format(rat.getBirthday());
            form.setBirthday(formattedBirthday);

            form.setPrice(rat.getPrice());
            form.setSex(rat.getSex());
            form.setSize(rat.getSize());

            //TODO:form.setPhoto1/2/3 all require multipartfile, rat.getPhoto1/2/3 returns path string
            //if form is submitted without setPhoto, will it remove existing photo?


            form.setRatStatus(rat.getRatStatus());
        } else {
            log.warn("Rat with id " + id + " was not found");
        }

        response.addObject("form", form);

        return response;
    }

    @PostMapping("/rat/editSubmit")
    public ModelAndView editSubmit(@Valid CreateRatFormBean form, BindingResult bindingResult,HttpSession session) throws ParseException {

        if (bindingResult.hasErrors()) {
            log.info("######################### In edit rat - has errors #########################");
            ModelAndView response = new ModelAndView("rat/edit");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("############ In edit rat - no error found #############");


        Rat r = ratService.updateRat(form);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/");

        return response;
    }


}
