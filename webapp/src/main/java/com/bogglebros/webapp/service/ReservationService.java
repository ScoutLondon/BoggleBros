package com.bogglebros.webapp.service;

import com.bogglebros.webapp.database.dao.OrderDAO;
import com.bogglebros.webapp.database.dao.RatDAO;
import com.bogglebros.webapp.database.dao.ReservationDAO;
import com.bogglebros.webapp.database.entity.Order;
import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.database.entity.Reservation;
import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.formbean.CreateOrderFormBean;
import com.bogglebros.webapp.formbean.CreateReservationFormBean;
import com.bogglebros.webapp.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDao;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private RatDAO ratDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @PreAuthorize("hasAuthority('USER')")
    public Reservation createReservation(CreateReservationFormBean form){

        Reservation reservation = reservationDao.findById(form.getId());

        if ( reservation == null){
            reservation = new Reservation();
            reservation.setTimestamp(new Date());
        }

        Order order = orderDao.findById(form.getOrderId());
        reservation.setOrder(order);

        Rat rat = ratDao.findById(form.getRatId());
        reservation.setRat(rat);


       reservation.setReservationStatus(form.getReservationStatus());


        return reservationDao.save(reservation);
    }
}
