package com.api.controleestacionamento.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ESTACIONAMENTO")
public class Estacionamento{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true, length = 10)
    private String nrVagaEstacionamento;

    @Column(nullable = false, unique = true, length = 12)
    private String placaCarro;

    @Column(nullable = false, length = 70)
    private String marcaCarro;

    @Column(nullable = false, length = 70)
    private String modeloCarro;

    @Column(nullable = false, length = 70)
    private String corCarro;

    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    @Column(nullable = false, length = 130)
    private String proprietarioCarro;

    @Column(nullable = false, length = 30)
    private String apartamento;

    @Column(nullable = false, length = 30)
    private String blocoApartamento;

   public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

    public String getModeloCarro() {
        return modeloCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
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

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
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
