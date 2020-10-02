package com.br.digitalhouse.agsc.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.digitalhouse.agsc.oficina.model.Cliente;
import com.br.digitalhouse.agsc.oficina.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente create(Cliente cliente) {
		cliente.setId(null);
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente update(Cliente novo) {
	
		Cliente antigo = this.findById(novo.getId())
				.orElse(new Cliente());
		
		antigo.setNome(novo.getNome());
		antigo.setVeiculos(novo.getVeiculos());
		
		return this.clienteRepository.save(antigo);
	}
	
	public Optional<Cliente> findById(Long id) {
		
		return this.clienteRepository.findById(id);
	}
	
	public Optional<List<Cliente>> findAll(){
		return Optional.of(this.clienteRepository.findAll());
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		
		this.clienteRepository.deleteById(id);
	}
}
