package com.essj.temperaturecontrol.repository;

import com.essj.temperaturecontrol.dto.MediaDiariaDTO;
import com.essj.temperaturecontrol.dto.MediaMensalDTO;
import com.essj.temperaturecontrol.model.Medicao;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {

    // Últimas 10 medições
    List<Medicao> findTop10ByOrderByDataHoraDesc();

    // Média por dia (nativa)
    @Query(value = """
    SELECT DATE(m.data_hora) AS data,
           AVG(m.temperatura) AS media_temperatura,
           AVG(m.umidade) AS media_umidade
    FROM medicao m
    GROUP BY DATE(m.data_hora)
    ORDER BY DATE(m.data_hora) DESC
    """, nativeQuery = true)
    List<Object[]> calcularMediaPorDia();

    // Média por mês (nativa)
    @Query(value = """
    SELECT EXTRACT(YEAR FROM m.data_hora) AS ano,
           EXTRACT(MONTH FROM m.data_hora) AS mes,
           AVG(m.temperatura) AS media_temperatura,
           AVG(m.umidade) AS media_umidade
    FROM medicao m
    GROUP BY EXTRACT(YEAR FROM m.data_hora), EXTRACT(MONTH FROM m.data_hora)
    ORDER BY ano DESC, mes DESC
    """, nativeQuery = true)
    List<Object[]> calcularMediaPorMes();
}
