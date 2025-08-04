package com.essj.temperaturecontrol.controller.web;


import com.essj.temperaturecontrol.dto.MediaDiariaDTO;
import com.essj.temperaturecontrol.dto.MediaMensalDTO;
import com.essj.temperaturecontrol.model.Medicao;
import com.essj.temperaturecontrol.repository.MedicaoRepository;
import com.essj.temperaturecontrol.service.MedicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MedicaoPageController {

    @Autowired
    private MedicaoService medicaoService;

    private final MedicaoRepository medicaoRepository;

    public MedicaoPageController(MedicaoRepository medicaoRepository) {
        this.medicaoRepository = medicaoRepository;
    }

    @GetMapping("/painel")
    public String painel(Model model) {
        model.addAttribute("medicoes", medicaoService.obterUltimasMedicoes());
        model.addAttribute("mediasDiarias", medicaoService.obterMediaDiaria());  // lista de DTOs
        model.addAttribute("mediasMensais", medicaoService.obterMediaPorMes());  // lista de DTOs
        return "painel";
    }
}
