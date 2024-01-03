package com.bogglebros.webapp.controller;

import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.formbean.CreateRatFormBean;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bogglebros.webapp.service.RatService;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;

@Slf4j
@Controller
public class RatController {

    @Autowired
    private RatService ratService;

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

}
