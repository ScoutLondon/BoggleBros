package com.bogglebros.webapp.service;

import com.bogglebros.webapp.database.dao.RatDAO;
import com.bogglebros.webapp.database.dao.UserDAO;
import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.formbean.CreateRatFormBean;
import com.bogglebros.webapp.formbean.RegisterUserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(RegisterUserFormBean form){
        log.debug("id: " + form.getId());
        log.debug("email: " + form.getEmail());
        log.info("password: " + form.getPassword());
        log.info("createDate: " + form.getCreateDate());
        log.info("firstName: " + form.getFirstName());
        log.info("lastName: " + form.getLastName());
        log.info("city: " + form.getCity());
        log.info("yearsExperience: " + form.getYearsExperience());
        log.info("currentRatsDesc: " + form.getCurrentRatsDesc());
        log.info("careDesc: " + form.getCareDesc());
        log.info("breederStatus: " + form.getBreederStatus());
        log.info("sexPref: " + form.getSexPref());
        log.info("phone: " + form.getPhone());


        User user = userDao.findById(form.getId());

        if ( user == null){
            user = new User();
            user.setCreateDate(form.getCreateDate());
        }

        user.setEmail(form.getEmail());

        String encoded = passwordEncoder.encode(form.getPassword());
        user.setPassword(encoded);

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setYearsExperience(form.getYearsExperience());
        user.setCurrentRatsDesc(form.getCurrentRatsDesc());
        user.setCareDesc(form.getCareDesc());
        user.setBreederStatus(form.getBreederStatus());
        user.setSexPref(form.getSexPref());
        user.setPhone(form.getPhone());

        return userDao.save(user);
    }
}