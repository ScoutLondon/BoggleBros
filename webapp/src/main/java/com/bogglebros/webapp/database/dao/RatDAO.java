package com.bogglebros.webapp.database.dao;

import com.bogglebros.webapp.database.entity.Rat;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatDAO extends JpaRepository<Rat, Long> {

    public Rat findById(Integer id);

    public Rat findByName(String name);

    @Query("SELECT r from Rat r WHERE r.ratStatus = :ratStatus")
    List<Rat> findByRatStatus(String ratStatus);

    @Query(nativeQuery = true, value = "SELECT * FROM rats")
    List<Rat> findAllRats();

    @Modifying
    @Transactional
    int deleteByName(String name);

}