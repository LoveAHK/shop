package com.example.Shop.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String index()
    {
        return "redirect:/Main";
    }

    @GetMapping("/Main")
    public String success(Authentication authentication)
    {

        String role = authentication.getAuthorities().toString();
        System.out.print(role);
        if(role.contains("ARENDODATEL"))

        {
            return "/MainArenda";
        }
        else if(role.contains("KASSIR"))
        {
            return "/MainKassir";
        }
        else if(role.contains("KKADOVSHIK"))
        {
            return "/MainKladovshik";
        }
        else if(role.contains("ADMIN"))
        {
            return "/MainAdmin";
        }

        return "/Main";
    }
}
