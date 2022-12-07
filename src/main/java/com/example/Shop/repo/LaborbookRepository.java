package com.example.Shop.repo;

import com.example.Shop.Models.Arenda;
import com.example.Shop.Models.Laborbook;
import com.example.Shop.Models.Mesto;
import com.example.Shop.Models.Personal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LaborbookRepository extends CrudRepository<Laborbook, Long> {
    Laborbook findByNomer(Integer nomer);
    List<Laborbook> findByNomerContains(String nomer);
}
