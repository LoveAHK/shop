package com.example.Shop.repo;

import com.example.Shop.Models.Tovar;
import com.example.Shop.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    UserDetails findByUsername(String username);




}
