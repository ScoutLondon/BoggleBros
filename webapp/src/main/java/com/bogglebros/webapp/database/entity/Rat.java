package com.bogglebros.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "adopter_id")
    private Integer adopterId;

    @Column(name = "adoption_status")
    private String adoptionStatus;

}