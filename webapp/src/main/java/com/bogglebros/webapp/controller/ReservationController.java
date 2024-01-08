package com.bogglebros.webapp.controller;

import com.bogglebros.webapp.database.dao.OrderDAO;
import com.bogglebros.webapp.database.dao.ReservationDAO;
import com.bogglebros.webapp.database.entity.Order;
import com.bogglebros.webapp.database.entity.Rat;
import com.bogglebros.webapp.database.entity.Reservation;
import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.formbean.CreateOrderFormBean;
import com.bogglebros.webapp.formbean.CreateRatFormBean;
import com.bogglebros.webapp.formbean.CreateReservationFormBean;
import com.bogglebros.webapp.security.AuthenticatedUserService;
import com.bogglebros.webapp.service.OrderService;
import com.bogglebros.webapp.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        Reservation reservationCheck = reservationDao.findByOrderIdAndRatId(openOrder.getId(), id);
        if(reservationCheck == null) {

            CreateReservationFormBean newReservationForm = new CreateReservationFormBean();
            newReservationForm.setReservationStatus("Pending");
            newReservationForm.setOrderId(openOrder.getId());
            newReservationForm.setRatId(id);

            Reservation newReservation = reservationService.createReservation(newReservationForm);
            reservationDao.save(newReservation);

            log.debug("##### New reservation id: " + newReservation.getId() + " created #####");

        }

        List<Reservation> reservations = reservationDao.findByOrderId(openOrder.getId());
        openOrder.setReservations(reservations);
        orderDao.save(openOrder);

        log.debug("##### Reservation list updated for order " + openOrder.getId());
        for (Reservation r: reservations){
            log.debug("##### Reservation id: " + r.getId() + "rat: " + r.getRat().getName() + " status: " + r.getReservationStatus());
        }

        return  response;
    }

    @GetMapping("/reservation/view")
    public ModelAndView reservationView() {
        ModelAndView response = new ModelAndView("reservation/view");
        log.info("In reservation view with no args");
        User user = authenticatedUserService.loadCurrentUser();
        Order order = orderDao.findByUserIdAndOrderStatus(user.getId(), "Open");
        List<Reservation> reservations = reservationDao.findByOrderIdAndReservationStatus(order.getId(), "Pending");
        response.addObject("reservationList", reservations);
        for (Reservation reservation : reservations){
            log.debug("Reservation: id = " + reservation.getId() + " Rat = " + reservation.getRat());
        }
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reservation/manage")
    public ModelAndView manageReservations() {
        ModelAndView response = new ModelAndView("reservation/manage");
        log.info("In edit reservations view with no args");
        List<Reservation> reservations = reservationDao.findAllReservations();
        response.addObject("reservationList", reservations);
        for (Reservation reservation : reservations){
            log.debug("Reservation: id = " + reservation.getId() + " Rat = " + reservation.getRat());
        }
        return response;
    }

    @GetMapping("/reservation/edit/{id}")
    //use this for edit/id/x vs edit?id=x
    public ModelAndView editReservation(@PathVariable int id){
        ModelAndView response = new ModelAndView("reservation/edit");
        log.info("In edit reservation with id: " + id);

        Reservation reservation = reservationDao.findById(id);

        CreateReservationFormBean form = new CreateReservationFormBean();

        if ( reservation != null) {
            form.setId(reservation.getId());
            log.debug("form ID set to: " + form.getId());
            form.setReservationStatus(form.getReservationStatus());
            form.setRatId(reservation.getRat().getId());
            form.setOrderId(reservation.getOrder().getId());
        } else {
            log.warn("Reservation with id " + id + " was not found");
        }

        log.debug("form reservationStatus set to: " + form.getReservationStatus());
        log.debug("form ratId set to: " + form.getRatId());
        log.debug("form orderId set to: " + form.getOrderId());
        response.addObject("form", form);

        return response;
    }

    @PostMapping("/reservation/editSubmit")
    public ModelAndView editSubmit(@Valid CreateReservationFormBean form, BindingResult bindingResult, HttpSession session) throws ParseException {

        if (bindingResult.hasErrors()) {
            log.info("######################### In edit reservation - has errors #########################");
            ModelAndView response = new ModelAndView("reservation/edit");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("############ In edit reservation - no error found #############");


        Reservation r = reservationService.createReservation(form);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/");

        return response;
    }

}
