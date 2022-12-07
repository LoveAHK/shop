package com.example.Shop.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Mesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    @OneToMany(mappedBy = "mesto", fetch = FetchType.EAGER)
    private Collection<Arenda> tenants;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public Collection<Arenda> getTenants() {return tenants;}
    public void setTenants(Collection<Arenda> tenants) {this.tenants = tenants;}
}
