package com.example.Shop.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Personal  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 30,message = "Размер данного поля должен быть в диапазоне от 2 до 30")
    @Pattern(regexp = "^([а-яА-Яё]+)$",
            message = "Значение должно содержать буквы русского или латинского алфавита")
    private String surname,name,middlename,street;
    @NotEmpty(message = "Поле не может быть пустым")
    private String birthday;

    @NotEmpty(message = "Поле не может быть пустым")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String snils;

    @NotEmpty(message = "Поле не может быть пустым")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String home,flat,salary;
    @NotEmpty(message = "Поле не может быть пустым")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String seriapasporta;
    @NotEmpty(message = "Поле не может быть пустым")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String nomerpasporta;


    @NotEmpty(message = "Поле не может быть пустым")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String thebuildingofthehouse;
    private boolean active;



    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;


    public Laborbook getLaborbook() {
        return laborbook;
    }

    public void setLaborbook(Laborbook laborbook) {
        this.laborbook = laborbook;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private Laborbook laborbook;

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Mesto mesto;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getBirthday() {return birthday;}
    public void setBirthday(String birthday) {this.birthday = birthday;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public String getMiddlename() {return middlename;}
    public void setMiddlename(String middlename) {this.middlename = middlename;}
    public String getSeriapasporta() {return seriapasporta;}
    public void setSeriapasporta(String seriapasporta) {this.seriapasporta = seriapasporta;}
    public String getNomerpasporta() {return nomerpasporta;}
    public void setNomerpasporta(String nomerpasporta) {this.nomerpasporta = nomerpasporta;}
    public String getSnils() {return snils;}
    public void setSnils(String snils) {this.snils = snils;}
    public String getHome() {return home;}
    public void setHome(String home) {this.home = home;}
    public String getFlat() {return flat;}
    public void setFlat(String flat) {this.flat = flat;}
    public String getSalary() {return salary;}
    public void setSalary(String salary) {this.salary = salary;}
    public String getThebuildingofthehouse() {return thebuildingofthehouse;}
    public void setThebuildingofthehouse(String thebuildingofthehouse) {this.thebuildingofthehouse = thebuildingofthehouse;}
    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;}
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
