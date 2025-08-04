package com.essj.temperaturecontrol.controller.web;


import com.essj.temperaturecontrol.dto.MediaDiariaDTO;
import com.essj.temperaturecontrol.dto.MediaMensalDTO;
import com.essj.temperaturecontrol.model.Medicao;
import com.essj.temperaturecontrol.repository.MedicaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MedicaoPageController {

    private final MedicaoRepository medicaoRepository;

    public MedicaoPageController(MedicaoRepository medicaoRepository) {
        this.medicaoRepository = medicaoRepository;
    }

    @GetMapping("/painel")
    public String verPainel(Model model) {
        List<Medicao> ultimas10 = medicaoRepository.findTop10ByOrderByDataHoraDesc();
        List<MediaDiariaDTO> mediasDiarias = medicaoRepository.calcularMediaPorDia();
        List<MediaMensalDTO> mediasMensais = medicaoRepository.calcularMediaPorMes();

        model.addAttribute("medicoes", ultimas10);
        model.addAttribute("mediasDiarias", mediasDiarias);
        model.addAttribute("mediasMensais", mediasMensais);

        return "painel";
    }
}
