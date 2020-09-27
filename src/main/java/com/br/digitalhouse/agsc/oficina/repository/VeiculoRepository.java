package com.br.digitalhouse.agsc.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.digitalhouse.agsc.oficina.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	
}
