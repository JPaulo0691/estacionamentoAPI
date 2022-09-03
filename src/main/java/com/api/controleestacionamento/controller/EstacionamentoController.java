package com.api.controleestacionamento.controller;

import com.api.controleestacionamento.dto.EstacionamentoDTO;
import com.api.controleestacionamento.model.Estacionamento;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.controleestacionamento.services.EstacionamentoService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/controle-estacionamento")
public class EstacionamentoController {

    final EstacionamentoService estacionamentoService;

    public EstacionamentoController(EstacionamentoService estacionamentoService) {
        this.estacionamentoService = estacionamentoService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarEstacionamento(@RequestBody @Valid EstacionamentoDTO estacionamentoDTO){

        // lembrar de isolar estas responsabilidades em um custom Validator,para melhoria do código

        if(estacionamentoService.existsByplacaCarro(estacionamentoDTO.getPlacaCarro())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Já existe carro cadastrado com essa placa!");
        }

        if(estacionamentoService.existsBynrVagaEstacionamento(estacionamentoDTO.getNrVagaEstacionamento())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Essa vaga de Estacionamento está ocupada!");
        }

        if(estacionamentoService.existsByApartamentoAndBlocoApartamento(estacionamentoDTO.getApartamento(), estacionamentoDTO.getBlocoApartamento())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Vaga de Estacionamento já cadastrada para este Apto e Bloco!");
        }

        var estacionamento = new Estacionamento();

        BeanUtils.copyProperties(estacionamentoDTO, estacionamento); // aqui está sendo convertido o DTO para o model
        estacionamento.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(estacionamentoService.save(estacionamento));
    }

    @GetMapping
    public ResponseEntity<List<Estacionamento>> consultarVagasEstacionamento(){
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultarPorId(@PathVariable(value = "id") Integer id){

        //estudar o que é Optional
        Optional<Estacionamento> estacionamentoOptional = estacionamentoService.findById(id);

        if(!estacionamentoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nr Vaga de Estacionamento não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoOptional.get());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarVagaEstacionamento(@PathVariable(value = "id") Integer id){
    	
    	 Optional<Estacionamento> estacionamentoOptional = estacionamentoService.findById(id);
    	 
    	 if(!estacionamentoOptional.isPresent()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nr Vaga de Estacionamento não encontrada");
         }
    	 
    	 estacionamentoService.delete(estacionamentoOptional.get());
    	 
    	 return ResponseEntity.status(HttpStatus.OK).body("Vaga de Estacionamento deletada com sucesso.");   	 
    	 
    }  
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id, 
    		@RequestBody @Valid EstacionamentoDTO estacionamentoDTO){
    	
    	Optional<Estacionamento> estacionamentoOptional = estacionamentoService.findById(id);
    	
    	if(!estacionamentoOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nr Vaga de Estacionamento não Encontrada");    		
    	}
    	
    	var estacionamento = estacionamentoOptional.get();
    	
    	estacionamento.setNrVagaEstacionamento(estacionamentoDTO.getNrVagaEstacionamento());
    	estacionamento.setPlacaCarro(estacionamentoDTO.getPlacaCarro());
    	estacionamento.setMarcaCarro(estacionamentoDTO.getMarcaCarro());
    	estacionamento.setModeloCarro(estacionamentoDTO.getModeloCarro());
    	estacionamento.setCorCarro(estacionamentoDTO.getCorCarro());
    	estacionamento.setProprietarioCarro(estacionamentoDTO.getProprietarioCarro());
    	estacionamento.setApartamento(estacionamentoDTO.getApartamento());
    	estacionamento.setBlocoApartamento(estacionamentoDTO.getBlocoApartamento());    	
    	
    	
    	ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.save(estacionamento));
    	    	
    	return ResponseEntity.status(HttpStatus.OK).body("Dados atualizados com Sucesso!");
    }
    
    
}
