package com.gabrielgarcia.futhype.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielgarcia.futhype.dto.ProdutoDTO;
import com.gabrielgarcia.futhype.entities.Produto;
import com.gabrielgarcia.futhype.repositories.ProdutoRepository;







@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
		Optional<Produto> resultado = produtoRepository.findById(id);
		Produto produto = resultado.get();
		ProdutoDTO dto = new ProdutoDTO(produto);
		return dto;
	}
	
}
