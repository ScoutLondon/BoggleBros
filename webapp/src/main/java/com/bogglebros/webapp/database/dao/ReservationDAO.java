package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.Reservation;
import com.bogglebros.webapp.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Long> {
    public Reservation findById(Integer id);

    @Query("SELECT c from Reservation c WHERE c.order.id = :orderId")
    List<Reservation> findByOrderId(Integer orderId);

    @Query("SELECT c from Reservation c WHERE c.rat.id = :ratId")
    List<Reservation> findByRatId(Integer ratId);

}