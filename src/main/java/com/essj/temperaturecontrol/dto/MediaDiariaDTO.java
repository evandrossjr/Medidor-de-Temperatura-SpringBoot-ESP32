package com.essj.temperaturecontrol.dto;

import java.time.LocalDate;

public class MediaDiariaDTO {
    private LocalDate data;
    private Double mediaTemperatura;
    private Double mediaUmidade;

    public MediaDiariaDTO(LocalDate data, Double mediaTemperatura, Double mediaUmidade) {
        this.data = data;
        this.mediaTemperatura = mediaTemperatura;
        this.mediaUmidade = mediaUmidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getMediaTemperatura() {
        return mediaTemperatura;
    }

    public void setMediaTemperatura(Double mediaTemperatura) {
        this.mediaTemperatura = mediaTemperatura;
    }

    public Double getMediaUmidade() {
        return mediaUmidade;
    }

    public void setMediaUmidade(Double mediaUmidade) {
        this.mediaUmidade = mediaUmidade;
    }

}
