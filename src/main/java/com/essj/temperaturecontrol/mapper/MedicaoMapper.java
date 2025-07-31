package com.essj.temperaturecontrol.mapper;

import com.essj.temperaturecontrol.dto.MedicaoDTO;
import com.essj.temperaturecontrol.model.Medicao;

public class MedicaoMapper {

    public static MedicaoDTO toDTO(Medicao medicao){
        if (medicao == null ) return null;

        return new MedicaoDTO(
                medicao.getTemperatura(), medicao.getUmidade()
        );

    }

    public static Medicao toEntity(MedicaoDTO medicaoDTO){
        if (medicaoDTO == null ) return null;

       Medicao medicao = new Medicao();
       medicao.setTemperatura(medicaoDTO.temperatura());
       medicao.setUmidade(medicaoDTO.umidade());

       return medicao;

    }
}
