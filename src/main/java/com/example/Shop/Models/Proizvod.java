package com.example.Shop.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Proizvod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String country;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country;
    }

    public Collection<Tovar> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Tovar> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "proizvod", fetch = FetchType.EAGER)
    private Collection<Tovar> tenants;
}
