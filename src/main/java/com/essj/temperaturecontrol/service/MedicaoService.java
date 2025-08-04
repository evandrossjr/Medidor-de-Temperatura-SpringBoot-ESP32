package com.essj.temperaturecontrol.service;


import com.essj.temperaturecontrol.dto.MediaDiariaDTO;
import com.essj.temperaturecontrol.dto.MediaMensalDTO;
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
import java.util.stream.Collectors;

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


    public List<Medicao> obterUltimasMedicoes() {
        return medicaoRepository.findTop10ByOrderByDataHoraDesc();
    }

    public List<MediaDiariaDTO> obterMediaDiaria() {
        List<Object[]> resultados = medicaoRepository.calcularMediaPorDia();
        return resultados.stream()
                .map(obj -> new MediaDiariaDTO(
                        ((java.sql.Date) obj[0]).toLocalDate(),
                        ((Double) obj[1]),
                        ((Double) obj[2])
                ))
                .collect(Collectors.toList());
    }



    public List<MediaMensalDTO> obterMediaPorMes() {
        List<Object[]> resultados = medicaoRepository.calcularMediaPorMes();
        return resultados.stream().map(obj -> new MediaMensalDTO(
                ((Number) obj[0]).intValue(),
                ((Number) obj[1]).intValue(),
                ((Number) obj[2]).doubleValue(),
                ((Number) obj[3]).doubleValue()
        )).collect(Collectors.toList());
    }


}
