package com.example.Shop.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Oplatasposob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sposobsale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSposobsale() {
        return sposobsale;
    }

    public void setSposobsale(String sposobsale) {
        sposobsale = sposobsale;
    }

    public Collection<Checks> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Checks> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "oplatasposob", fetch = FetchType.EAGER)
    private Collection<Checks> tenants;
}
