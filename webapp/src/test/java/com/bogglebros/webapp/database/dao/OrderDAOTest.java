package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bogglebros.webapp.database.entity.Order;


import java.util.Date;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderDAOTest {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private UserDAO userDAO;



    @Test
    @org.junit.jupiter.api.Order(1)
    public void createOrderTest(){
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
        user = userDAO.save(user);

        Order order = new Order();
        order.setOrderStatus("qwertyqwerty");
        order.setUser(user);


        //when
        order = orderDAO.save(order);

        //then
        Assertions.assertNotNull(order.getId());
        Assertions.assertEquals("qwertyqwerty", order.getOrderStatus());

    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void findByOrderStatusTest(){
        //given
        String orderStatus = "qwertyqwerty";

        //when
        Order order = orderDAO.findByOrderStatus(orderStatus);

        //then
        Assertions.assertNotNull(order.getId());
        Assertions.assertEquals("qwertyqwerty", order.getOrderStatus());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void deleteOrderTest(){
        //given
        String orderStatus = "qwertyqwerty";

        //when
        int deletedOrder = orderDAO.deleteByOrderStatus(orderStatus);
        int deletedUser = userDAO.deleteByEmail("qwertyqwerty");

        //then
        Assertions.assertEquals(1, deletedOrder);
        Assertions.assertEquals(1, deletedUser);
    }

}
