package com.br.digitalhouse.agsc.oficina.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@OneToMany
	@JoinColumn(name="cliente_id")
	private Set<Veiculo> veiculos = new HashSet<Veiculo>();
}
