package com.example.Shop.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
public class Tovar {
    public Tovar(String nametovar, Producttype producttype, Proizvod proizvod) {
        this.nametovar = nametovar;
        this.producttype = producttype;
        this.proizvod = proizvod;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 50,message = "Размер данного поля должен быть в диапазоне от 2 до 50")
    @Pattern(regexp = "^([а-яА-Яё]+|[a-zA-Z]+)$",
            message = "Значение должно содержать буквы русского или латинского алфавита")
    private String nametovar;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Producttype producttype;

    public Tovar() {
    }
    public Collection<Tovarcheck> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Tovarcheck> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "tovar", fetch = FetchType.EAGER)
    private Collection<Tovarcheck> tenants;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNametovar() {
        return nametovar;
    }

    public void setNametovar(String nametovar) {
        this.nametovar = nametovar;
    }

    public Producttype getProducttype() {
        return producttype;
    }

    public void setProducttype(Producttype producttype) {
        this.producttype = producttype;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Proizvod proizvod;
}
