package com.example.Shop.repo;

import com.example.Shop.Models.Producttype;
import org.springframework.data.repository.CrudRepository;

public interface ProducttypeRepository extends CrudRepository<Producttype,Long> {
    Producttype findByTiptovara(String tiptovara);
}
