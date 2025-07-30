package com.essj.temperaturecontrol.controller;


import com.essj.temperaturecontrol.dto.MedicaoDTO;
import com.essj.temperaturecontrol.model.Medicao;
import com.essj.temperaturecontrol.service.MedicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicao")
public class MedicaoController {

    @Autowired
    private MedicaoService medicaoService;



    @PostMapping("/tempatual")
    public void receberTempAtual(@RequestBody MedicaoDTO medicaoDTO){
        medicaoService.registrarTemperaturaAtual(medicaoDTO);
    }

    @GetMapping("/tempatual")
    public Medicao obterAtual(){
        return medicaoService.obterUltimaMedicao();
    }

    @PostMapping("/historico")
    public void salvarHistorico(@RequestBody MedicaoDTO medicaoDTO){
        medicaoService.salvarHistórico(medicaoDTO);
    }

    @GetMapping("/historico")
    public List<MedicaoDTO> listarHistorico() {
        return medicaoService.listarHistorico();
    }




}
