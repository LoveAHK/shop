package com.example.Shop.repo;

import com.example.Shop.Models.Oplatasposob;
import org.springframework.data.repository.CrudRepository;

public interface OplatasposobRepository extends CrudRepository<Oplatasposob,Long> {
    Oplatasposob findBySposobsale(String sposobsale);
}
