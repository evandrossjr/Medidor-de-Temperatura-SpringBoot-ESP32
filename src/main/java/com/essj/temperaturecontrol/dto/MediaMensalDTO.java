package com.essj.temperaturecontrol.dto;

public class MediaMensalDTO {

    private Integer ano;
    private Integer mes;
    private Double mediaTemperatura;
    private Double mediaUmidade;

    public MediaMensalDTO(Integer ano, Integer mes, Double mediaTemperatura, Double mediaUmidade) {
        this.ano = ano;
        this.mes = mes;
        this.mediaTemperatura = mediaTemperatura;
        this.mediaUmidade = mediaUmidade;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
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
