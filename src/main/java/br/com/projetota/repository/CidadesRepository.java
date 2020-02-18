package br.com.projetota.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetota.model.Cidades;

public interface CidadesRepository extends JpaRepository<Cidades, Integer>{

	public Page<Cidades>findByNomeContaining(String nome, Pageable pageable);
	
}
