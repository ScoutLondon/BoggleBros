package com.bogglebros.webapp.formbean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
public class RegisterUserFormBean {

    private Integer id;

    @Email(message = "Email must be a valid email address.")
    private String email;

    @Length(min=8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one lowercase letter, one uppercase letter, and one digit")
    private String password;

    private Date createDate;

    @NotEmpty(message = "First name is required.")
    @Length(max = 45, message = "First name must be less than 45 characters.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    @Length(max = 45, message = "Last name must be less than 45 characters.")
    private String lastName;

    @NotEmpty(message = "City is required.")
    @Length(max = 45, message = "City name must be less than 45 characters.")
    private String city;

    @NotEmpty(message = "State is required.")
    @Length(max = 45, message = "State name must be less than 45 characters.")
    private String state;

    @NotEmpty(message = "Years of rat-keeping experience is required.")
    @Length(max = 45, message = "Years of rat-keeping must be less than 45 characters.")
    private String years_experience;

    @NotEmpty(message = "Description of current rat ownership is required.")
    @Length(max = 1500, message = "Description of current rat ownership must be less than 1500 characters.")
    private String currentRatsDesc;

    @NotEmpty(message = "Description of care is required.")
    @Length(max = 1500, message = "Description of care must be less than 1500 characters.")
    private String careDesc;

    @NotEmpty(message = "Description of breeder status is required.")
    @Length(max = 45, message = "Breeder status must be less than 45 characters.")
    private String breederStatus;

    @NotEmpty(message = "Sex preference is required.")
    @Length(max = 45, message = "Sex preference must be less than 45 characters.")
    private String sexPref;

    @Length(max = 45, message = "Phone must be less than 45 characters.")
    private String phone;
}
