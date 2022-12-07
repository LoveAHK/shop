package com.example.Shop.Controller;

import com.example.Shop.Models.Arenda;
import com.example.Shop.Models.Checks;
import com.example.Shop.Models.Mesto;
import com.example.Shop.repo.ArendaRepository;
import com.example.Shop.repo.MestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ArendController {

   @Autowired
   private MestoRepository mestoRepository;
    @Autowired
    private ArendaRepository arendaRepository;

    @GetMapping("/MainArenda")
    public String GetRab(Model model)
    {
        Iterable<Arenda> arenda = arendaRepository.findAll();
        model.addAttribute("arenda",arenda);
        return "MainArenda";
    }
    @GetMapping("/Add/arenda")
    public String GetArenda(@ModelAttribute("arenda") Arenda arenda, Model model)
    {
        Iterable<Mesto> mesto = mestoRepository.findAll();
        model.addAttribute("mesto",mesto);
        return  "Add-arenda";
    }
    @PostMapping("/Add/arenda")
    public String blogPostAdd( @ModelAttribute("arenda") Arenda arenda, BindingResult bindingResult,
                               Model model)
    {
        Iterable<Mesto> mesto = mestoRepository.findAll();
        model.addAttribute("mesto",mesto);
        if (bindingResult.hasErrors()) {
            return "Add-arenda";
        }
        arendaRepository.save(arenda);
        return "redirect:/MainArenda";
    }
    @GetMapping("/Arenda/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Arenda> teacher = arendaRepository.findById(id);
        ArrayList<Arenda> res = new ArrayList<>();
        teacher.ifPresent(res::add);
        model.addAttribute("arenda", res);
        if(!arendaRepository.existsById(id))
        {
            return "redirect:/MainArenda";
        }
        return "Arenda-details";
    }
    @GetMapping("/Arenda/{id}/edit")
    public String blogEdit(@PathVariable("id")Long id,
                           Model model)
    {
        Arenda arenda = arendaRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid arenda Id" + id));
        model.addAttribute("arenda",arenda);
        Iterable<Mesto> mesto = mestoRepository.findAll();
        model.addAttribute("mesto",mesto);
        return "Arenda-edit";

    }
    @PostMapping("/Arenda/{id}/edit")
    public String blogPostUpdate(@ModelAttribute("arenda")@Valid Arenda arenda, BindingResult bindingResult,
                                 @PathVariable("id") Long id, Model model)
    {
        Iterable<Mesto> mesto = mestoRepository.findAll();
        model.addAttribute("mesto",mesto);
        arenda.setId(id);
        if (bindingResult.hasErrors()) {
            return "Arenda-edit";
        }
        arendaRepository.save(arenda);
        return "redirect:/MainArenda";
    }
    @PostMapping("/Arenda/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") Long id, Model model){
        Arenda arenda = arendaRepository.findById(id).orElseThrow();
        arendaRepository.delete(arenda);
        return "redirect:/MainArenda";
    }
    @GetMapping( path = "/Search/Arenda")
    public String blogFilter(Model model)
    {
        return "Search-Arenda";
    }
    @PostMapping("/Search/Arenda")
    public String simpleSearch(@RequestParam String street, Model model)
    {
        List<Arenda> arenda = arendaRepository.findByStreetContains(street);
        model.addAttribute("result", arenda);
        return "Search-Arenda";
    }

}
