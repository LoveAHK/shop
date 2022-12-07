package com.example.Shop.repo;

import com.example.Shop.Models.Producttype;
import com.example.Shop.Models.Proizvod;
import com.example.Shop.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TovarRepository extends CrudRepository<Tovar, Long> {
    List<Tovar> findByNametovarContains(String nametovar);

}
