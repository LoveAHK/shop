package com.example.Shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainControlller {
    @GetMapping("/logout")
    public String Glavn(Model model)
    {
        return "Main";
    }
    @PostMapping("/logout")
    public String Stud(Model model)
    {
        return "logout";
    }

}
