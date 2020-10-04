package com.br.digitalhouse.agsc.oficina.service;

import com.br.digitalhouse.agsc.oficina.model.OrdemServico;
import com.br.digitalhouse.agsc.oficina.repository.OrdemServicoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;

    @Autowired
    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public OrdemServico create(OrdemServico ordemServico){
        ordemServico.setId(null);
        return this.ordemServicoRepository.save(ordemServico);
    }

    public OrdemServico update(OrdemServico novo) {
    	OrdemServico antigo = this.findById(novo.getId());
    	
    	antigo.setCliente(novo.getCliente());
    	antigo.setVeiculo(novo.getVeiculo());
    	
    	return this.ordemServicoRepository.save(antigo);
    }
    
    public OrdemServico findById(Long id) {
    	Optional
		.ofNullable(id)
		.orElseThrow(() -> new RuntimeException("ID nulo"));
		
		return this.ordemServicoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi possivel encontrar esse ID"));
    }
    
    public List<OrdemServico> findAll(){
    	return this.ordemServicoRepository.findAll();
    }
    
    public void deleteById(Long id) {
    	this.findById(id);
    	
    	this.ordemServicoRepository.deleteById(id);
    }
}
