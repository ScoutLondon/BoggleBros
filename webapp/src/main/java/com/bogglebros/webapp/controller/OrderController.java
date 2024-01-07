package com.bogglebros.webapp.controller;

import com.bogglebros.webapp.database.dao.OrderDAO;
import com.bogglebros.webapp.database.dao.ReservationDAO;
import com.bogglebros.webapp.database.entity.Order;
import com.bogglebros.webapp.database.entity.Reservation;
import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private ReservationDAO reservationDao;

    @GetMapping("/order/view")
    public ModelAndView orderView() {
        ModelAndView response = new ModelAndView("order/view");
        log.info("In order view with no args");
        User user = authenticatedUserService.loadCurrentUser();
        Order order = orderDao.findByUserIdAndOrderStatus(user.getId(), "Open");
        List<Reservation> reservations = reservationDao.findByOrderIdAndReservationStatus(order.getId(), "Approved");
        response.addObject("reservationList", reservations);
        for (Reservation reservation : reservations){
            log.debug("Reservation: id = " + reservation.getId() + " Rat = " + reservation.getRat());
        }
        return response;
    }

}
