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
        SELECT DATE(data_hora) AS data,
               AVG(temperatura) AS media_temperatura,
               AVG(umidade) AS media_umidade
        FROM medicao
        GROUP BY DATE(data_hora)
        ORDER BY DATE(data_hora) DESC
        """, nativeQuery = true)
    List<Object[]> calcularMediaPorDia();

    // Média por mês (nativa)
    @Query(value = """
        SELECT EXTRACT(YEAR FROM data_hora) AS ano,
               EXTRACT(MONTH FROM data_hora) AS mes,
               AVG(temperatura) AS media_temperatura,
               AVG(umidade) AS media_umidade
        FROM medicao
        GROUP BY EXTRACT(YEAR FROM data_hora), EXTRACT(MONTH FROM data_hora)
        ORDER BY ano DESC, mes DESC
        """, nativeQuery = true)
    List<Object[]> calcularMediaPorMes();
}
