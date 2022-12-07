package com.example.Shop.repo;

import com.example.Shop.Models.Checks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChecksRepository  extends CrudRepository<Checks, Long> {
    List<Checks> findByInnContains(String inn);
}
