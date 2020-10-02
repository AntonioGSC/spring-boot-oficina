package com.br.digitalhouse.agsc.oficina.service;

import com.br.digitalhouse.agsc.oficina.model.Veiculo;
import com.br.digitalhouse.agsc.oficina.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;


	public Veiculo create(Veiculo veiculo) {
		veiculo.setId(null);
		return this.veiculoRepository.save(veiculo);
	}
	
	public Veiculo update(Veiculo novo) {
	
		Veiculo antigo = this.findById(novo.getId())
				.orElse(new Veiculo());
		
		antigo.setCor(novo.getCor());
		antigo.setMarca(novo.getMarca());
		antigo.setModelo(novo.getModelo());
		antigo.setPlaca(novo.getPlaca());
		
		return this.veiculoRepository.save(antigo);
	}
	
	public Optional<Veiculo> findById(Long id) {
		return this.veiculoRepository.findById(id);
	}
	
	public Optional<List<Veiculo>> findAll(){
		return Optional.of(this.veiculoRepository.findAll());
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		
		this.veiculoRepository.deleteById(id);
	}
}
