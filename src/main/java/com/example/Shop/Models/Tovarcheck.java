package com.example.Shop.Models;

import javax.persistence.*;

@Entity
public class Tovarcheck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Tovar tovar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
    }

    public Checks getChek() {
        return checks;
    }

    public void setChek(Checks chek) {
        this.checks = chek;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Checks checks;
}
