package com.br.digitalhouse.agsc.oficina.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.digitalhouse.agsc.oficina.model.Veiculo;
import com.br.digitalhouse.agsc.oficina.repository.VeiculoRepository;

@Service
public class VeiculoService {

//	@Autowired
//	private VeiculoRepository veiculoRepository;
	
	private final VeiculoRepository veiculoRepository;

	@Autowired
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	public Veiculo create(Veiculo veiculo) {
		veiculo.setId(null);
		return this.veiculoRepository.save(veiculo);
	}
	
	public Veiculo update(Veiculo veiculo) {
		Long id = Optional
					.ofNullable(veiculo.getId())
					.orElseThrow(() -> new RuntimeException("ID nulo"));
	
		return this.findById(id);
	}
	
	public Veiculo findById(Long id) {
		Optional
		.ofNullable(id)
		.orElseThrow(() -> new RuntimeException("ID nulo"));
		
		return this.veiculoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi possivel encontrar esse ID"));
	}
}
