package com.api.controleestacionamento.repositories;

import com.api.controleestacionamento.model.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Integer> {

    boolean existsByplacaCarro(String placaCarro);
    boolean existsBynrVagaEstacionamento(String nrVagaEstacionamento);
    boolean existsByApartamentoAndBlocoApartamento(String apartamento, String blocoApartamento);
    
}
