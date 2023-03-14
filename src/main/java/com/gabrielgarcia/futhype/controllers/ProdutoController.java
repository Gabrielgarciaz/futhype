package com.gabrielgarcia.futhype.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielgarcia.futhype.dto.ProdutoDTO;
import com.gabrielgarcia.futhype.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/{id}")
	public ProdutoDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public Page<ProdutoDTO> findAll(Pageable pagina) {
		return service.findAll(pagina);
	}
}
