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


    public Checks(int summi, int kolvotovar, Tovar tovar, Oplatasposob oplatasposob, Personal personal) {
        this.summi = summi;
        this.kolvotovar = kolvotovar;
        this.tovar = tovar;
        this.oplatasposob = oplatasposob;
        this.personal = personal;
    }

    public Checks() {
    }

    public Checks(int summi, int kolvotovar,Tovar tovar, Personal personal, Oplatasposob oplatasposob) {
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

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
    }
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Oplatasposob oplatasposob;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Personal personal;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Tovar tovar;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
