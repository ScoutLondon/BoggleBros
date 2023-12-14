package com.bogglebros.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "rats")
public class Rat
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "genes")
    private String genes;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "price")
    private Integer price;

    @Column(name = "sex")
    private String sex;

    @Column(name = "size")
    private String size;

    @Column(name = "photo1")
    private String photo1;

    @Column(name = "photo2")
    private String photo2;

    @Column(name = "photo3")
    private String photo3;

    @Column(name = "rat_status")
    private String ratStatus;

}