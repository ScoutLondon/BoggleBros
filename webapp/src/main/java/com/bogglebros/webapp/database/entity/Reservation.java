package com.bogglebros.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "rat_id")
    private Integer ratId;

    @Column(name = "reservation_status")
    private String reservationStatus;

    @Column(name = "timestamp")
    private Date timestamp;

}
