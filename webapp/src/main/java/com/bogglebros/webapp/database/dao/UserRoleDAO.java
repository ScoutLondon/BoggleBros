package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    public UserRole findById(Integer id);

}
