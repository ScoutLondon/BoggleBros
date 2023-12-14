package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.Reservation;
import com.bogglebros.webapp.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Long> {
    public Reservation findById(Integer id);

}