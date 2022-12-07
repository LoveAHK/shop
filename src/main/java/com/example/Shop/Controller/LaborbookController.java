package com.example.Shop.Controller;

import com.example.Shop.Models.*;
import com.example.Shop.repo.ArendaRepository;
import com.example.Shop.repo.LaborbookRepository;
import com.example.Shop.repo.PostRepository;
import com.example.Shop.repo.SotrudnikRepository;
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
public class LaborbookController    {
    @Autowired
    private LaborbookRepository laborbookRepository;

    @Autowired
    private PostRepository postRepository;
    @GetMapping("/MainLab")
    public String GetRab(Model model)
    {
        Iterable<Laborbook> laborbooks = laborbookRepository.findAll();
        model.addAttribute("laborbooks",laborbooks);
        return "MainLab";
    }
    @GetMapping("/Add/lab")
    public String GetArenda(@ModelAttribute("laborbook")Laborbook laborbook,Model model)
    {
       // laborbook.setPost(new Post());
        LocalDate datelimit = LocalDate.now();
        Iterable<Post> post = postRepository.findAll();
        model.addAttribute("post",post);
        model.addAttribute("datelimit",datelimit);

        return  "Add-lab";
    }
    @PostMapping("/Add/lab")
    public String blogLabAdd( @ModelAttribute("laborbook")@Valid Laborbook laborbook, BindingResult bindingResult,
                              Model model)
    { LocalDate datelimit = LocalDate.now();
        Iterable<Post> post = postRepository.findAll();
        model.addAttribute("post",post);
        laborbookRepository.save(laborbook);
        model.addAttribute("datelimit",datelimit);
        if (bindingResult.hasErrors()) {
            return "Add-lab";
        }
        return "redirect:/MainLab";
    }
    @GetMapping("/Labor/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Laborbook> laborbook = laborbookRepository.findById(id);
        ArrayList<Laborbook> res = new ArrayList<>();
        laborbook.ifPresent(res::add);
        model.addAttribute("laborbook", res);
        if(!laborbookRepository.existsById(id))
        {
            return "redirect:/MainLab";
        }
        return "Labor-details";
    }
    @GetMapping("/Labor/{id}/edit")
    public String blogEdit(@PathVariable("id")Long id,
                           Model model)
    {
        Laborbook laborbook = laborbookRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid arenda Id" + id));
        model.addAttribute("laborbook",laborbook);
        Iterable<Post> post = postRepository.findAll();
        model.addAttribute("post",post);
        return "Labor-edit";

    }
    @PostMapping("/Labor/{id}/edit")
    public String blogPostUpdate(@ModelAttribute("laborbook")@Valid Laborbook laborbook, BindingResult bindingResult,
                                 @PathVariable("id") Long id, Model model)
    {
        LocalDate datelimit = LocalDate.now();
        Iterable<Post> post = postRepository.findAll();
        model.addAttribute("post",post);
        model.addAttribute("datelimit",datelimit);
        laborbook.setId(id);
        if (bindingResult.hasErrors()) {
            return "Labor-edit";
        }
        laborbookRepository.save(laborbook);
        return "redirect:/MainLab";
    }
    @PostMapping("/Labor/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") Long id,Laborbook laborbook, Model model){
         laborbook = laborbookRepository.findById(id).orElseThrow();
        laborbookRepository.delete(laborbook);
        return "redirect:/MainLab";
    }
    @GetMapping( path = "/Search/Lab")
    public String blogFilter(Model model)
    {
        return "Search-Lab";
    }
    @PostMapping("/Search/Lab")
    public String simpleSearch(@RequestParam String nomer, Model model)
    {
        List<Laborbook> laborbook = laborbookRepository.findByNomerContains(nomer);
        model.addAttribute("result", laborbook);
        return "Search-Lab";
    }
}
