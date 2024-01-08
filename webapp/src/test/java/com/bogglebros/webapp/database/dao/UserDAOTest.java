package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    public void createUserTest(){
        //given
        Date date = new Date();

        User user = new User();
        user.setEmail("qwertyqwerty");
        user.setPassword("qwertyqwerty");
        user.setCreateDate(date);
        user.setFirstName("qwertyqwerty");
        user.setLastName("qwertyqwerty");
        user.setCity("qwertyqwerty");
        user.setState("qwertyqwerty");
        user.setYearsExperience("qwertyqwerty");
        user.setCurrentRatsDesc("qwertyqwerty");
        user.setCareDesc("qwertyqwerty");
        user.setBreederStatus("qwertyqwerty");
        user.setSexPref("qwertyqwerty");
        user.setPhone("qwertyqwerty");


        //when
        user = userDAO.save(user);

        //then
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals("qwertyqwerty", user.getEmail());
        Assertions.assertEquals("qwertyqwerty", user.getPassword());
        Assertions.assertEquals("qwertyqwerty", user.getFirstName());
        Assertions.assertEquals("qwertyqwerty", user.getLastName());
        Assertions.assertEquals("qwertyqwerty", user.getCity());
        Assertions.assertEquals("qwertyqwerty", user.getState());
        Assertions.assertEquals("qwertyqwerty", user.getYearsExperience());
        Assertions.assertEquals("qwertyqwerty", user.getCurrentRatsDesc());
        Assertions.assertEquals("qwertyqwerty", user.getCareDesc());
        Assertions.assertEquals("qwertyqwerty", user.getBreederStatus());
        Assertions.assertEquals("qwertyqwerty", user.getSexPref());
        Assertions.assertEquals("qwertyqwerty", user.getPhone());
    }

    @Test
    @Order(2)
    public void findByEmailIgnoreCaseTest(){
        //given
        String email = "qwertyqwerty";

        //when
        User user = userDAO.findByEmailIgnoreCase(email);

        //then
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals("qwertyqwerty", user.getEmail());
        Assertions.assertEquals("qwertyqwerty", user.getPassword());
        Assertions.assertEquals("qwertyqwerty", user.getFirstName());
        Assertions.assertEquals("qwertyqwerty", user.getLastName());
        Assertions.assertEquals("qwertyqwerty", user.getCity());
        Assertions.assertEquals("qwertyqwerty", user.getState());
        Assertions.assertEquals("qwertyqwerty", user.getYearsExperience());
        Assertions.assertEquals("qwertyqwerty", user.getCurrentRatsDesc());
        Assertions.assertEquals("qwertyqwerty", user.getCareDesc());
        Assertions.assertEquals("qwertyqwerty", user.getBreederStatus());
        Assertions.assertEquals("qwertyqwerty", user.getSexPref());
        Assertions.assertEquals("qwertyqwerty", user.getPhone());
    }

    @Test
    @Order(3)
    public void deleteUserTest(){
        //given
        String email = "qwertyqwerty";

        //when
        int deleted = userDAO.deleteByEmail(email);

        //then
        Assertions.assertEquals(1, deleted);
    }


}
