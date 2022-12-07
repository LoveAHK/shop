package com.example.Shop.Controller;

import com.example.Shop.Models.*;
import com.example.Shop.repo.LaborbookRepository;
import com.example.Shop.repo.MestoRepository;
import com.example.Shop.repo.SotrudnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class RegistrationController {
    @Autowired
    private SotrudnikRepository userRepository;
    @Autowired
    private MestoRepository mestoRepository;
    @Autowired
    private LaborbookRepository laborbookRepository;
    @Autowired
    private SotrudnikRepository sotrudnikRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @GetMapping("/MainSotr")
    public String GetRab(Model model)
    {
        Iterable<Personal> personal = userRepository.findAll();
        model.addAttribute("personal",personal);
        return "MainSotr";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("personal")  Personal personal, Model model){
        personal.setUser(new User());
        personal.setLaborbook(new Laborbook());
        Iterable<Mesto> mesto = mestoRepository.findAll();
        model.addAttribute("mesto",mesto);
        Iterable<Laborbook> laborbooks = laborbookRepository.findAll();
        model.addAttribute("laborbooks",laborbooks);
        model.addAttribute("selectRole", Role.USER);
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("personal") @Valid Personal personal, BindingResult employeeResult,
                          @RequestParam Role role,
                          Model model){

        Set<Role> roles = personal.getUser().getRoles();
        roles.add(role);
        personal.setActive(true);
        personal.getUser().setRoles(roles);
        Iterable<Mesto> mesto = mestoRepository.findAll();
        model.addAttribute("mesto",mesto);
        Iterable<Laborbook> laborbooks = laborbookRepository.findAll();
        model.addAttribute("laborbooks",laborbooks);

        personal.getUser().setPassword(passwordEncoder.encode(personal.getUser().getPassword()));


         if(employeeResult.hasErrors())
         {
             return "/registration";
         }

        userRepository.save(personal);
        return "redirect:/login";

    }
    @GetMapping("/Personal/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Personal> personal = userRepository.findById(id);
        ArrayList<Personal> res = new ArrayList<>();
        personal.ifPresent(res::add);
        model.addAttribute("checks", res);
        if(!userRepository.existsById(id))
        {
            return "redirect:/MainSotr";
        }
        return "Sotr-details";
    }
    @GetMapping("/Personal/{id}/edit")
    public String blogEdit(@PathVariable("id")Long id,
                           Model model)
    {
        Personal personal = userRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid arenda Id" + id));
        model.addAttribute("personal",personal);
        Iterable<Mesto> mesto = mestoRepository.findAll();
        Iterable<Laborbook> laborbook = laborbookRepository.findAll();
        model.addAttribute("mesto",mesto);
        model.addAttribute("laborbook",laborbook);
        return "Personal-edit";

    }
    @PostMapping("/Personal/{id}/edit")
    public String blogPostUpdate(@ModelAttribute("personal")@Valid Personal personal, BindingResult bindingResult,
                                 @PathVariable("id") Long id, Model model)
    {
        Iterable<Mesto> mesto = mestoRepository.findAll();
        Iterable<Laborbook> laborbook = laborbookRepository.findAll();
        model.addAttribute("mesto",mesto);
        model.addAttribute("laborbook",laborbook);
        personal.setId(id);
        if (bindingResult.hasErrors()) {
            return "Personal-edit";
        }
        userRepository.save(personal);
        return "redirect:/MainSotr";
    }
    @PostMapping("/Personal/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") Long id, Model model){
        Personal personal = userRepository.findById(id).orElseThrow();
        userRepository.delete(personal);
        return "redirect:/MainPersonal";
    }

    @GetMapping( path = "/Search/Sotr")
    public String blogFilter(Model model)
    {
        return "Search-Sotr";
    }
    @PostMapping("/Search/Sotr")
    public String simpleSearch(@RequestParam String surname, Model model)
    {
        List<Personal> personal = sotrudnikRepository.findBySurnameContains(surname);
        model.addAttribute("personal", personal);
        return "Search-Sotr";
    }
}
