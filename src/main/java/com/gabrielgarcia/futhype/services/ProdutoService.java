package com.gabrielgarcia.futhype.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		Produto produto = produtoRepository.findById(id).get();
		return  new ProdutoDTO(produto);
	}
	
	@Transactional(readOnly = true)
	public Page<ProdutoDTO> findAll(Pageable pagina) {
		Page<Produto> produtos = produtoRepository.findAll(pagina);
		return produtos.map(x -> new ProdutoDTO(x));
	}
}
