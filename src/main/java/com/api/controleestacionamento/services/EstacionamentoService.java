package com.api.controleestacionamento.services;

import com.api.controleestacionamento.model.Estacionamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.controleestacionamento.repositories.EstacionamentoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstacionamentoService{

    @Autowired
    final EstacionamentoRepository estacionamentoRepository;

    public EstacionamentoService(EstacionamentoRepository estacionamentoRepository){
        this.estacionamentoRepository = estacionamentoRepository;
    }

    @Transactional
    public Estacionamento save(Estacionamento estacionamento) {

        return estacionamentoRepository.save(estacionamento);
    }

   public boolean existsByplacaCarro(String placaCarro) {
        return  estacionamentoRepository.existsByplacaCarro(placaCarro);
    }

   public boolean existsBynrVagaEstacionamento(String nrVagaEstacionamento) {

       return estacionamentoRepository.existsBynrVagaEstacionamento(nrVagaEstacionamento);
   }

   public boolean existsByApartamentoAndBlocoApartamento(String apartamento, String blocoApartamento) {
       return estacionamentoRepository.existsByApartamentoAndBlocoApartamento(apartamento,blocoApartamento);
   }

    public List<Estacionamento> findAll() {
        return estacionamentoRepository.findAll();
    }

    public Optional<Estacionamento> findById(UUID id) {

        return estacionamentoRepository.findById(id);
    }
}