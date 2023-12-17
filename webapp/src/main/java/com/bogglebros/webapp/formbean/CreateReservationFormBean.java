package com.bogglebros.webapp.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateReservationFormBean {

    private Integer id;

    @NotEmpty(message = "Reservation Status is required.")
    @Length(max = 45, message = "Reservation Status must be less than 45 characters.")
    private String reservationStatus;

}
