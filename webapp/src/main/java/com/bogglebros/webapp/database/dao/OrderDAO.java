package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.Order;
import com.bogglebros.webapp.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {
    public Order findById(Integer id);

    public Order findByUserIdAndOrderStatus(Integer id, String orderStatus);

}
