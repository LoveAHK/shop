package com.example.Shop.Models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Arenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 30,message = "Размер данного поля должен быть в диапазоне от 2 до 30")
    @Pattern(regexp = "^([а-яА-Яё]+)$",
            message = "Значение должно содержать буквы русского  алфавита")
    private String street;

    @NotEmpty(message = "Поле не может быть пустым")
    private String datenachala;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 10,message = "Размер данного поля должен быть в диапазоне от 2 до 10")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String nomerdogovora;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Mesto mesto;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getDatenachala() {return datenachala;}
    public void setDatenachala(String datenachala) {this.datenachala = datenachala;}
    public String getNomerdogovora() {return nomerdogovora;}
    public void setNomerdogovora(String nomerdogovora) {this.nomerdogovora = nomerdogovora;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public Mesto getMesto() {return mesto;}
    public void setMesto(Mesto mesto) {this.mesto = mesto;}
    public Arenda(String datenachala, String nomerdogovora, String street, Mesto mesto) {
        this.datenachala = datenachala;
        this.nomerdogovora = nomerdogovora;
        this.street = street;
        this.mesto = mesto;
    }
    public Arenda() {
    }
}
