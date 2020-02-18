package br.com.projetota.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetota.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{

	public Page<Clientes>findByNomeContaining(String nome, Pageable pageable);
	
}
