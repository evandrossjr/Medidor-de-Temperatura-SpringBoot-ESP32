package com.essj.temperaturecontrol.controller;

import com.essj.temperaturecontrol.dto.AlexaRequestDTO;
import com.essj.temperaturecontrol.dto.AlexaResponseDTO;
import com.essj.temperaturecontrol.model.Medicao;
import com.essj.temperaturecontrol.service.MedicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alexa")
public class AlexaController {

    @Autowired
    private MedicaoService medicaoService;

    @PostMapping
    public AlexaResponseDTO processarAlexa(@RequestBody AlexaRequestDTO req) {
        String tipo = req.getRequest().getType();

        if ("LaunchRequest".equals(tipo)) {
            Medicao ultima = medicaoService.obterUltimaMedicao();

            if (ultima.getTemperatura() > 28){
                String resposta = "Agora está fazendo " + ultima.getTemperatura() + " graus, " +
                        "com umidade de " + ultima.getUmidade() + " por cento.";

                return AlexaResponseDTO.buildSpeech(resposta);
            }

            if (ultima.getTemperatura() < 28){
                String resposta = "Agora está fazendo " + ultima.getTemperatura() + " graus, " +
                        "com umidade de " + ultima.getUmidade() + " por cento.";

                return AlexaResponseDTO.buildSpeech(resposta);
            }

        }

        if ("IntentRequest".equals(tipo)) {
            String intent = req.getRequest().getIntent().getName();

            if ("ObterTemperaturaIntent".equals(intent)) {
                Medicao ultima = medicaoService.obterUltimaMedicao();
                String resposta = "A temperatura é " + ultima.getTemperatura() +
                        " graus, com umidade de " + ultima.getUmidade() + " por cento.";
                return AlexaResponseDTO.buildSpeech(resposta);
            }
        }

        return AlexaResponseDTO.buildSpeech("Desculpe, não entendi.");
    }

}
