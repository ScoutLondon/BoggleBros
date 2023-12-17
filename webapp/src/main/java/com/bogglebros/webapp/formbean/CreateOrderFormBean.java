package com.bogglebros.webapp.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateOrderFormBean {

    private Integer id;

    @NotEmpty(message = "Order Status is required.")
    @Length(max = 45, message = "Order Status must be less than 45 characters.")
    private String orderStatus;

}
