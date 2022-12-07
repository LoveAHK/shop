package com.example.Shop.repo;

import com.example.Shop.Models.Personal;

import com.example.Shop.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SotrudnikRepository extends CrudRepository<Personal, Long> {
    Personal findBySurname(String surname);
    List<Personal> findBySurnameContains(String surname);
}
