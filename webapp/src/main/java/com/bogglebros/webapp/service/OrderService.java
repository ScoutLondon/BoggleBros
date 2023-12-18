package com.bogglebros.webapp.service;

import com.bogglebros.webapp.database.dao.OrderDAO;
import com.bogglebros.webapp.database.dao.RatDAO;
import com.bogglebros.webapp.database.dao.ReservationDAO;
import com.bogglebros.webapp.database.entity.Order;
import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.formbean.CreateOrderFormBean;
import com.bogglebros.webapp.formbean.CreateRatFormBean;
import com.bogglebros.webapp.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private ReservationDAO reservationDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public Order createOrder(CreateOrderFormBean form){

        Order order = orderDao.findById(form.getId());

        if ( order == null){
            order = new Order();
        }

        User user = authenticatedUserService.loadCurrentUser();

        order.setUser(user);

        order.setOrderStatus(form.getOrderStatus());


        //HOW TO SET LIST OF RESERVATIONS?
        order.setReservations(reservationDao.findByOrderId(form.getId()));




        return orderDao.save(order);
    }
}
