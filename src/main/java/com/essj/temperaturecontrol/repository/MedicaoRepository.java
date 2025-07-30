package com.essj.temperaturecontrol.repository;

import com.essj.temperaturecontrol.model.Medicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {
}
