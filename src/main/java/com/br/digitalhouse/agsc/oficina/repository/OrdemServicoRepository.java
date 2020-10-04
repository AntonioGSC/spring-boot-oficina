package com.br.digitalhouse.agsc.oficina.repository;

import com.br.digitalhouse.agsc.oficina.model.OrdemServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
