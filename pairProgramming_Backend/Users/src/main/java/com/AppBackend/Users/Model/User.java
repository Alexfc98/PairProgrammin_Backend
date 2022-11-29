package com.AppBackend.Users.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
public class User {

    @Id
    @NotBlank
    private String id;

    @Column(name="Name", length=50)
    @NotBlank
    private String Name;

    @Column(name="Surname", length=50)
    @NotBlank
    private String Surname;

    @Column(name="Age")
    @NotNull
    private int Age;

    @Column(name="Nationality", length=30)
    @NotBlank
    private String Nationality;

    @Column(name="DNI", length=10)
    @NotBlank
    private String DNI;
}
