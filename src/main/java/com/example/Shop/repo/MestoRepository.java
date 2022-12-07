package com.example.Shop.repo;

import com.example.Shop.Models.Mesto;
import org.springframework.data.repository.CrudRepository;

public interface MestoRepository extends CrudRepository<Mesto,Long> {
Mesto findByCity(String city);
}
