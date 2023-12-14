package com.bogglebros.webapp.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateRatFormBean {

    private Integer id;

    @NotEmpty(message = "Rat Name is required.")
    @Length(max = 100, message = "Name must be less than 100 characters.")
    private String name;

    @NotEmpty(message = "Rat Genetics are required.")
    @Length(max = 100, message = "Rat Genetics must be less than 100 characters.")
    private String genes;

    private Integer adopterId;

    @NotEmpty(message = "Adoption Status is required.")
    @Length(max = 100, message = "Adoption Status must be less than 100 characters.")
    private String adoptionStatus;

    @NotEmpty(message = "Rat Sex is required.")
    @Length(max = 100, message = "Rat sex must be less than 45 characters.")
    private String sex;
}