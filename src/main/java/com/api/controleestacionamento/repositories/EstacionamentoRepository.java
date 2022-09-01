package com.api.controleestacionamento.repositories;

import com.api.controleestacionamento.model.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, UUID> {

    boolean existsByplacaCarro(String placaCarro);
    boolean existsBynrVagaEstacionamento(String nrVagaEstacionamento);
    boolean existsByApartamentoAndBlocoApartamento(String apartamento, String blocoApartamento);
}
