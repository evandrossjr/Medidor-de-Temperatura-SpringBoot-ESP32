package com.essj.temperaturecontrol.service;


import com.essj.temperaturecontrol.dto.MedicaoDTO;
import com.essj.temperaturecontrol.mapper.MedicaoMapper;
import com.essj.temperaturecontrol.model.Medicao;
import com.essj.temperaturecontrol.repository.MedicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MedicaoService {

    @Autowired
    private MedicaoRepository medicaoRepository;

    private final AtomicReference<Medicao> ultimaMedicao = new AtomicReference<>();

    public void registrarTemperaturaAtual(MedicaoDTO medicaoDTO){
        Medicao medicao = new Medicao();
        medicao.setTemperatura(medicaoDTO.temperatura());
        medicao.setUmidade(medicaoDTO.umidade());
        medicao.setDataHora(LocalDateTime.now());
        ultimaMedicao.set(medicao);
    }

    public void salvarHistórico(MedicaoDTO medicaoDTO){
        Medicao medicao = new Medicao();
        medicao.setTemperatura(medicaoDTO.temperatura());
        medicao.setUmidade(medicaoDTO.umidade());
        medicao.setDataHora(LocalDateTime.now());
        medicaoRepository.save(medicao);
    }

    public Medicao obterUltimaMedicao(){
        return ultimaMedicao.get();
    }

    public List<MedicaoDTO> listarHistorico(){
        return medicaoRepository.findAll().stream().map(MedicaoMapper::toDTO).toList();
    }
}
