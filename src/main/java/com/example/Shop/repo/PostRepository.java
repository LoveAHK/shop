package com.example.Shop.repo;


import com.example.Shop.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
    Post findByPostname(String postname);
}
