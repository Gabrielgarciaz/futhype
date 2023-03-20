package com.gabrielgarcia.futhype.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gabrielgarcia.futhype.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("SELECT obj FROM Produto obj"
			+ " WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
	Page<Produto> searchByName(String nome, Pageable pageable);
}
