package com.example.Shop.Controller;

import com.example.Shop.Models.Personal;
import com.example.Shop.Models.Role;
import com.example.Shop.repo.SotrudnikRepository;
import com.example.Shop.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static com.example.Shop.Models.Role.KASSIR;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN','KASSIR','ARENDODATEL','KKADOVSHIK')")

public class WebUserController {
    @Autowired
    private SotrudnikRepository userRepository;
    @GetMapping
    public String userList(Model model){
        model.addAttribute("personal", userRepository.findAll());
        return "userList";
    }

    @GetMapping("/{id}/edit")
    public String userEdit(@PathVariable(value = "id") long id, Model model){
        Optional<Personal> user = userRepository.findById(id);
        ArrayList<Personal> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("personal", res);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam(name="roles[]", required = false) String[] roles,
                           @RequestParam("userId") Personal user){

        return "redirect:/admin";
    }
}

