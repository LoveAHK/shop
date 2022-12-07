package com.example.Shop.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Producttype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tiptovara;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTiptovara() {
        return tiptovara;
    }

    public void setTiptovara(String tiptovara) {
        this.tiptovara = tiptovara;
    }

    public Collection<Tovar> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Tovar> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "producttype", fetch = FetchType.EAGER)
    private Collection<Tovar> tenants;
}
