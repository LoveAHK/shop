package com.example.Shop.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
@Entity
public class Laborbook {
    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Personal> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Personal> tenants) {
        this.tenants = tenants;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 30,message = "Размер данного поля должен быть в диапазоне от 2 до 30")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String nomer;
    @NotEmpty(message = "Поле не может быть пустым")
    private String datenach;

    public Laborbook(String nomer, String datenach, Post post) {
    }

    public Laborbook() {

    }



    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Post post;
    @OneToMany(mappedBy = "laborbook", fetch = FetchType.EAGER)
    private Collection<Personal> tenants;

    public Long getId() {
        return id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getDatenach() {
        return datenach;
    }

    public void setDatenach(String datenach) {
        this.datenach = datenach;
    }

}
