package com.example.Shop.Models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
public class Checks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        @NotNull
        @Min(value = 0,message = "Минимальное 1")
    private int summi,kolvotovar;


    public Checks(int summi, int kolvotovar, String inn, Oplatasposob oplatasposob, Personal personal) {
        this.summi = summi;
        this.kolvotovar = kolvotovar;
        this.inn = inn;
        this.oplatasposob = oplatasposob;
        this.personal = personal;
    }
    @NotEmpty(message = "Заполните поле")
    @Size(min = 1, max = 12,message = "Размер данного поля должен быть в диапазоне от 1 до 12")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String inn;

    public Checks() {
    }

    public Checks(String inn, int summi, int kolvotovar, Personal personal, Oplatasposob oplatasposob) {
    }


    public Collection<Tovarcheck> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Tovarcheck> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "checks", fetch = FetchType.EAGER)
    private Collection<Tovarcheck> tenants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public int getSummi() {
        return summi;
    }

    public void setSummi(int summi) {
        this.summi = summi;
    }

    public int getKolvotovar() {
        return kolvotovar;
    }

    public void setKolvotovar(int kolvotovar) {
        this.kolvotovar = kolvotovar;
    }


    public Oplatasposob getOplatasposob() {
        return oplatasposob;
    }

    public void setOplatasposob(Oplatasposob oplatasposob) {
        this.oplatasposob = oplatasposob;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Oplatasposob oplatasposob;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
