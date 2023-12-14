package com.bogglebros.webapp.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
public class CreateRatFormBean {

    private Integer id;

    @NotEmpty(message = "Rat Name is required.")
    @Length(max = 45, message = "Name must be less than 45 characters.")
    private String name;

    @NotEmpty(message = "Rat Genetics are required.")
    @Length(max = 150, message = "Rat Genetics must be less than 150 characters.")
    private String genes;

    @NotEmpty(message = "Birthday is required")
    private Date birthday;

    @NotEmpty(message = "Price is required.")
    @Length(max = 45, message = "Price must be less than 45 characters.")
    private Integer price;

    @NotEmpty(message = "Rat Sex is required.")
    @Length(max = 45, message = "Rat sex must be less than 45 characters.")
    private String sex;

    @NotEmpty(message = "Rat Size is required.")
    @Length(max = 45, message = "Rat size must be less than 45 characters.")
    private String size;

    private String photo1;

    private String photo2;

    private String photo3;

    @NotEmpty(message = "Rat Status is required.")
    @Length(max = 45, message = "Rat status must be less than 45 characters.")
    private String ratStatus;



}