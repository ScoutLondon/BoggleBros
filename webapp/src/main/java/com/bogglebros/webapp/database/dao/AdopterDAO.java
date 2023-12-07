package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdopterDAO extends JpaRepository<Adopter, Long> {
    public Adopter findById(Integer id);

}