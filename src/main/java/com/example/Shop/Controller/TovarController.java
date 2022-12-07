package com.example.Shop.Controller;

import com.example.Shop.Models.*;
import com.example.Shop.repo.ProizvodRepository;
import com.example.Shop.repo.ProducttypeRepository;
import com.example.Shop.repo.TovarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TovarController {
    @Autowired
    private TovarRepository tovarRepository;
    @Autowired
    private ProducttypeRepository producttypeRepository;
    @Autowired
    private ProizvodRepository proizvodRepository;

    @GetMapping("/MainTovar")
    public String GetRab(Model model) {
        Iterable<Tovar> tovar = tovarRepository.findAll();
        model.addAttribute("tovar", tovar);
        return "MainTovar";
    }

    @GetMapping("/Add/tovar")
    public String GetTovar(@ModelAttribute("tovar")Tovar tovar,Model model) {

        Iterable<Producttype> producttypes = producttypeRepository.findAll();
        Iterable<Proizvod> proizvod = proizvodRepository.findAll();
        model.addAttribute("proizvod",proizvod);
        model.addAttribute("producttypes",producttypes);
        return  "Add-tovar";
    }

    @PostMapping("/Add/tovar")
    public String blogTovarAdd(@ModelAttribute("tovar")@Valid Tovar tovar, BindingResult bindingResult,
                               Model model)
    {
        Iterable<Producttype> producttypes = producttypeRepository.findAll();
        Iterable<Proizvod> proizvod = proizvodRepository.findAll();
        model.addAttribute("proizvod",proizvod);
        model.addAttribute("producttypes",producttypes);
        if (bindingResult.hasErrors()) {
            return "Add-tovar";
        }
        tovarRepository.save(tovar);
        return "redirect:/MainTovar";

    }
    @GetMapping("/Tovar/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Tovar> tovar = tovarRepository.findById(id);
        ArrayList<Tovar> res = new ArrayList<>();
        tovar.ifPresent(res::add);
        model.addAttribute("tovar", res);
        if(!tovarRepository.existsById(id))
        {
            return "redirect:/MainTovar";
        }
        return "Tovar-details";
    }
    @GetMapping("/Tovar/{id}/edit")
    public String blogEdit(@PathVariable("id")Long id,
                           Model model)
    {
        Tovar tovar = tovarRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid arenda Id" + id));
        model.addAttribute("tovar",tovar);
        Iterable<Producttype> producttype = producttypeRepository.findAll();
        Iterable<Proizvod> proizvod = proizvodRepository.findAll();
        model.addAttribute("producttype",producttype);
        model.addAttribute("proizvod",proizvod);

        Iterable<Producttype> producttypes = producttypeRepository.findAll();
        model.addAttribute("producttypes",producttypes);
        return "Tovar-edit";

    }
    @PostMapping("/Tovar/{id}/edit")
    public String blogPostUpdate(@ModelAttribute("tovar")@Valid Tovar tovar, BindingResult bindingResult,
                                 @PathVariable("id") Long id, Model model)
    {
        Iterable<Producttype> producttype = producttypeRepository.findAll();
        Iterable<Proizvod> proizvod = proizvodRepository.findAll();
        model.addAttribute("producttype",producttype);
        model.addAttribute("proizvod",proizvod);
        tovar.setId(id);
        if (bindingResult.hasErrors()) {
            return "Tovar-edit";
        }
        tovarRepository.save(tovar);
        return "redirect:/MainTovar";
    }
    @PostMapping("/Tovar/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") Long id, Model model){
        Tovar tovar = tovarRepository.findById(id).orElseThrow();
        tovarRepository.delete(tovar);
        return "redirect:/MainTovar";
    }
    @GetMapping( path = "/Search/tovar")
    public String blogFilter(Model model)
    {
        return "Search-tovar";
    }
    @PostMapping("/Search/tovar")
    public String simpleSearch(@RequestParam String nametovar, Model model)
    {
        List<Tovar> tovar = tovarRepository.findByNametovarContains(nametovar);
        model.addAttribute("result", tovar);
        return "Search-tovar";
    }

}
