package com.essj.temperaturecontrol.repository;

import com.essj.temperaturecontrol.dto.MediaDiariaDTO;
import com.essj.temperaturecontrol.dto.MediaMensalDTO;
import com.essj.temperaturecontrol.model.Medicao;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {

    List<Medicao> findTop10ByOrderByDataHoraDesc();

    @Query("SELECT new com.essj.temperaturecontrol.dto.MediaDiariaDTO(" +
            "FUNCTION('DATE', m.dataHora), AVG(m.temperatura), AVG(m.umidade)) " +
            "FROM Medicao m GROUP BY FUNCTION('DATE', m.dataHora) ORDER BY FUNCTION('DATE', m.dataHora) DESC")
    List<MediaDiariaDTO> calcularMediaPorDia();


    @Query("SELECT new com.essj.temperaturecontrol.dto.MediaMensalDTO(" +
            "FUNCTION('YEAR', m.dataHora), FUNCTION('MONTH', m.dataHora), AVG(m.temperatura), AVG(m.umidade)) " +
            "FROM Medicao m " +
            "GROUP BY FUNCTION('YEAR', m.dataHora), FUNCTION('MONTH', m.dataHora) " +
            "ORDER BY FUNCTION('YEAR', m.dataHora) DESC, FUNCTION('MONTH', m.dataHora) DESC")
    List<MediaMensalDTO> calcularMediaPorMes();


}
