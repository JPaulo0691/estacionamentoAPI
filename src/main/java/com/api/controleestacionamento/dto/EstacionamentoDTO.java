package com.api.controleestacionamento.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EstacionamentoDTO {

    @NotBlank
    private String nrVagaEstacionamento;
    @NotBlank
    @Size(max = 12)
    private String placaCarro;
    @NotBlank
    private String marcaCarro;
    @NotBlank
    private String modeloCarro;
    @NotBlank
    private String corCarro;
    @NotBlank
    private String proprietarioCarro;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String blocoApartamento;

    public String getNrVagaEstacionamento() {
        return nrVagaEstacionamento;
    }

    public void setNrVagaEstacionamento(String nrVagaEstacionamento) {
        this.nrVagaEstacionamento = nrVagaEstacionamento;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getCorCarro() {
        return corCarro;
    }

    public void setCorCarro(String corCarro) {
        this.corCarro = corCarro;
    }

    public String getProprietarioCarro() {
        return proprietarioCarro;
    }

    public void setProprietarioCarro(String proprietarioCarro) {
        this.proprietarioCarro = proprietarioCarro;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getBlocoApartamento() {
        return blocoApartamento;
    }

    public void setBlocoApartamento(String blocoApartamento) {
        this.blocoApartamento = blocoApartamento;
    }
}
