package practice.springframework.sfgpetclinic.controllers;

import practice.springframework.sfgpetclinic.services.VetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    @Autowired
    private VetService vetService;

    @GetMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String index(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
