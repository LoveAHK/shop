package com.example.Shop.repo;

import com.example.Shop.Models.Proizvod;
import org.springframework.data.repository.CrudRepository;

public interface ProizvodRepository extends CrudRepository<Proizvod,Long> {
    Proizvod findByCountry(String country);
}
