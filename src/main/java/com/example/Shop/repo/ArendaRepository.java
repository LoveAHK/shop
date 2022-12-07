package com.example.Shop.repo;

import com.example.Shop.Models.Arenda;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArendaRepository extends CrudRepository<Arenda, Long> {
    List<Arenda> findByStreetContains(String street);
}
