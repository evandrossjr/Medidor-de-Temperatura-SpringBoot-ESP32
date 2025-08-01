package com.essj.temperaturecontrol.controller.web;


import com.essj.temperaturecontrol.repository.MedicaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicaoPageController {

    private final MedicaoRepository repo;

    public MedicaoPageController(MedicaoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/painel")
    public String verPainel(Model model) {
        model.addAttribute("medicoes", repo.findAll());
        return "painel";
    }
}
