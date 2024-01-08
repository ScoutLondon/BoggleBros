package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.Order;
import com.bogglebros.webapp.database.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {
    public Order findById(Integer id);

    public Order findByUserIdAndOrderStatus(Integer id, String orderStatus);

    public Order findByOrderStatus(String orderStatus);

    @Modifying
    @Transactional
    int deleteByOrderStatus(String orderStatus);

}
