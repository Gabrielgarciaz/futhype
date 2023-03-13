package com.gabrielgarcia.futhype.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielgarcia.futhype.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
