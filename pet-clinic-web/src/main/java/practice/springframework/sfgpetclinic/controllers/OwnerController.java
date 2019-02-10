package practice.springframework.sfgpetclinic.controllers;

import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerSerivce ownerSerivce;

    public OwnerController(OwnerSerivce ownerSerivce) {
        this.ownerSerivce = ownerSerivce;
    }

    @GetMapping({"", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("owners", ownerSerivce.findAll());
        return "owners/index";
    }
}
