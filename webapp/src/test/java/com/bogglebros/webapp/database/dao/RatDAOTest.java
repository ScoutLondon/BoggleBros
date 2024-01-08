package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.database.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RatDAOTest {

    @Autowired
    private RatDAO ratDAO;

    @Test
    @Order(1)
    public void createRatTest(){
        //given
        Date date = new Date();

        Rat rat = new Rat();
        rat.setName("qwertyqwerty");
        rat.setGenes("qwertyqwerty");
        rat.setBirthday(date);
        rat.setPrice(500);
        rat.setSex("qwertyqwerty");
        rat.setSize("qwertyqwerty");
        rat.setRatStatus("qwertyqwerty");


        //when
        rat = ratDAO.save(rat);

        //then
        Assertions.assertNotNull(rat.getId());
        Assertions.assertEquals("qwertyqwerty", rat.getName());
        Assertions.assertEquals("qwertyqwerty", rat.getGenes());
        Assertions.assertEquals(500, rat.getPrice());
        Assertions.assertEquals("qwertyqwerty", rat.getSex());
        Assertions.assertEquals("qwertyqwerty", rat.getSize());
        Assertions.assertEquals("qwertyqwerty", rat.getRatStatus());

    }

    @Test
    @Order(2)
    public void findByNameTest(){
        //given
        String name = "qwertyqwerty";

        //when
        Rat rat = ratDAO.findByName(name);

        //then
        Assertions.assertNotNull(rat.getId());
        Assertions.assertEquals("qwertyqwerty", rat.getName());
        Assertions.assertEquals("qwertyqwerty", rat.getGenes());
        Assertions.assertEquals(500, rat.getPrice());
        Assertions.assertEquals("qwertyqwerty", rat.getSex());
        Assertions.assertEquals("qwertyqwerty", rat.getSize());
        Assertions.assertEquals("qwertyqwerty", rat.getRatStatus());
    }

    @Test
    @Order(3)
    public void deleteRatTest(){
        //given
        String name = "qwertyqwerty";

        //when
        int deleted = ratDAO.deleteByName(name);

        //then
        Assertions.assertEquals(1, deleted);
    }

}
