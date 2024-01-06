package com.bogglebros.webapp.controller;

import com.bogglebros.webapp.database.dao.OrderDAO;
import com.bogglebros.webapp.database.dao.ReservationDAO;
import com.bogglebros.webapp.database.entity.Order;
import com.bogglebros.webapp.database.entity.Reservation;
import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.formbean.CreateOrderFormBean;
import com.bogglebros.webapp.formbean.CreateReservationFormBean;
import com.bogglebros.webapp.security.AuthenticatedUserService;
import com.bogglebros.webapp.service.OrderService;
import com.bogglebros.webapp.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class ReservationController {

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationDAO reservationDao;

    @GetMapping("/reservation/create")
    public ModelAndView reservationCreate(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("redirect:/rat/available");
        log.info("################# In create reservation #############");

        User user = authenticatedUserService.loadCurrentUser();
        log.debug("######## Current user " + user.getEmail() + " authenticated #########");

        Order openOrder = orderDao.findByUserIdAndOrderStatus(user.getId(), "Open");

        if (openOrder == null){
            log.debug("######## No open order found #######");

            CreateOrderFormBean newOrderForm = new CreateOrderFormBean();
            newOrderForm.setOrderStatus("Open");
            openOrder = orderService.createOrder(newOrderForm);
            openOrder.setUser(user);

            orderDao.save(openOrder);
            log.debug("####### New order " + openOrder.getId() + " created ########");

        }

        log.debug("####### In order id: " + openOrder.getId());


        CreateReservationFormBean newReservationForm = new CreateReservationFormBean();
        newReservationForm.setReservationStatus("Pending");
        newReservationForm.setOrderId(openOrder.getId());
        newReservationForm.setRatId(id);

        Reservation newReservation = reservationService.createReservation(newReservationForm);
        reservationDao.save(newReservation);

        log.debug("##### New reservation id: " + newReservation.getId() + " created #####");

        List<Reservation> reservations = reservationDao.findByOrderId(openOrder.getId());
        openOrder.setReservations(reservations);
        orderDao.save(openOrder);

        log.debug("##### Reservation list updated for order " + openOrder.getId());
        for (Reservation r: reservations){
            log.debug("##### Reservation id: " + r.getId() + "rat: " + r.getRat().getName() + " status: " + r.getReservationStatus());
        }

        return  response;
    }

}
