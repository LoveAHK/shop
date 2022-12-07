package com.example.Shop.Controller;

import com.example.Shop.Models.User;
import com.example.Shop.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("/{id}/edit")
    public String userEdit(@PathVariable(value = "id") long id, Model model){
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam(name="roles[]", required = false) String[] roles,
                           @RequestParam("userId") User user){
        user.setUsername(username);
        userRepository.save(user);

        return "redirect:/admin";
    }
}
