package com.example.secuirtymasterdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "code cannot be empty!")
    @Size(min = 2,max = 5,message = "code must be between 2 and 5.")
    @Pattern(regexp = "[A-Za-z]*",message = "code cannot contain illegal characters.")
    private String code;
    @NotBlank(message = "FirstName cannot be blank.")
    @Pattern(regexp = "[A-Za-z-]*",message = "FirstName cannot contain illegal character.")
    private String firstName;
    @NotBlank(message = "lastName cannot be blank!")
    @Pattern(regexp = "[A-Za-z-]*",message = "LastName cannot contain illegal character.")
    private String lastName;
    @NotBlank(message = "Address cannot be blank")
    @Pattern(regexp = "[\\w .\\-/,]*",message = "Address cannot contain illegal characters.")
    private String address;




}
