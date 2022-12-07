package com.example.Shop.Controller;


import com.example.Shop.Models.*;
import com.example.Shop.repo.ChecksRepository;
import com.example.Shop.repo.OplatasposobRepository;
import com.example.Shop.repo.SotrudnikRepository;
import org.hibernate.annotations.Check;
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
public class ChekController {
    @Autowired
    private ChecksRepository checksRepository;
    @Autowired
    private SotrudnikRepository sotrudnikRepository;
    @Autowired
    private OplatasposobRepository oplatasposobRepository;
    @GetMapping("/MainCheck")
    public String GetRab(Model model) {
        Iterable<Checks> cheks = checksRepository.findAll();
        model.addAttribute("cheks", cheks);
        return "MainCheck";
    }

    @GetMapping("/Add/check")
    public String GetTovar(@ModelAttribute("checks")Checks checks,Model model) {

        Iterable<Personal> personal = sotrudnikRepository.findAll();
        Iterable<Oplatasposob> oplatasposob = oplatasposobRepository.findAll();
        model.addAttribute("personals",personal);
        model.addAttribute("oplatasposob",oplatasposob);
        return  "Add-check";
    }

    @PostMapping("/Add/check")
    public String blogPostAdd(@ModelAttribute("checks")@Valid Checks checks, BindingResult bindingResult,
                              Model model)
    {
        Iterable<Personal> personals = sotrudnikRepository.findAll();
        Iterable<Oplatasposob> oplatasposob = oplatasposobRepository.findAll();
        model.addAttribute("personals",personals);
        model.addAttribute("oplatasposob",oplatasposob);
        if (bindingResult.hasErrors()) {
            return "Add-check";
        }
        checksRepository.save(checks);
        return "redirect:/MainCheck";

    }
    @GetMapping("/Check/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Checks> checks = checksRepository.findById(id);
        ArrayList<Checks> res = new ArrayList<>();
        checks.ifPresent(res::add);
        model.addAttribute("checks", res);
        if(!checksRepository.existsById(id))
        {
            return "redirect:/MainTovar";
        }
        return "Check-details";
    }
    @GetMapping("/Check/{id}/edit")
    public String blogEdit(@PathVariable("id")Long id,
                           Model model)
    {
        Checks checks = checksRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid arenda Id" + id));
        model.addAttribute("checks",checks);
        Iterable<Personal> personals = sotrudnikRepository.findAll();
        Iterable<Oplatasposob> oplatasposob = oplatasposobRepository.findAll();
        model.addAttribute("personals",personals);
        model.addAttribute("oplatasposob",oplatasposob);
        return "Check-edit";

    }
    @PostMapping("/Check/{id}/edit")
    public String blogPostUpdate(@ModelAttribute("check")@Valid Checks checks, BindingResult bindingResult,
                                 @PathVariable("id") Long id, Model model)
    {
        Iterable<Personal> personals = sotrudnikRepository.findAll();
        Iterable<Oplatasposob> oplatasposob = oplatasposobRepository.findAll();
        model.addAttribute("personals",personals);
        model.addAttribute("oplatasposob",oplatasposob);
        checks.setId(id);
        if (bindingResult.hasErrors()) {
            return "Check-edit";
        }
        checksRepository.save(checks);
        return "redirect:/MainCheck";
    }
    @PostMapping("/Check/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") Long id, Model model){
        Checks checks = checksRepository.findById(id).orElseThrow();
        checksRepository.delete(checks);
        return "redirect:/MainCheck";
    }
    @GetMapping( path = "/Search/check")
    public String blogFilter(Model model)
    {
        return "Search-check";
    }
    @PostMapping("/Search/check")
    public String simpleSearch(@RequestParam String inn, Model model)
    {
        List<Checks> cheks = checksRepository.findByInnContains(inn);
        model.addAttribute("cheks", cheks);
        return "Search-check";
    }
}
