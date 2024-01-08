package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    public User findById(Integer id);

    public User findByEmailIgnoreCase(String email);

    @Modifying
    @Transactional
    int deleteByEmail(String email);
}