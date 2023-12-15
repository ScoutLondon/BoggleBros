package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.User;
import com.bogglebros.webapp.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    public List<UserRole> findByUserId(Integer userId);

}
