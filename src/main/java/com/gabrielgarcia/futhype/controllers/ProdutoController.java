package com.gabrielgarcia.futhype.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielgarcia.futhype.dto.ProdutoDTO;
import com.gabrielgarcia.futhype.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	private ProdutoService service;
	
	@GetMapping(value = "/{id}")
	public ProdutoDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
