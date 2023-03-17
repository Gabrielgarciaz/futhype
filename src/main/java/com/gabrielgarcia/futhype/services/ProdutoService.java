package com.gabrielgarcia.futhype.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielgarcia.futhype.dto.ProdutoDTO;
import com.gabrielgarcia.futhype.entities.Produto;
import com.gabrielgarcia.futhype.repositories.ProdutoRepository;
import com.gabrielgarcia.futhype.services.exceptions.DataBaseException;
import com.gabrielgarcia.futhype.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return  new ProdutoDTO(produto);
	}
	
	@Transactional(readOnly = true)
	public Page<ProdutoDTO> findAll(Pageable pagina) {
		Page<Produto> produtos = produtoRepository.findAll(pagina);
		return produtos.map(x -> new ProdutoDTO(x));
	}
	
	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto produto = new Produto();
		CopiarDtoParaEntidade(dto, produto);
		produto = produtoRepository.save(produto);
		return new ProdutoDTO(produto);
		
	}
	
	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		try{
		Produto produto = produtoRepository.getReferenceById(id);  // Não vai no banco de dados
		CopiarDtoParaEntidade(dto, produto);
		produto = produtoRepository.save(produto);
		return new ProdutoDTO(produto);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
	}
	
	@Transactional
	public void delete(Long id) {
		try{
		produtoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		catch(DataIntegrityViolationException i) {
			throw new DataBaseException("Falha de integridade Referencial");
		}
	}
	
	private void CopiarDtoParaEntidade(ProdutoDTO dto, Produto produto) {
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setImgUrl(dto.getImgUrl());
	}
	
}
