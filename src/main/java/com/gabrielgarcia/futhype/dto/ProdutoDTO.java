package com.gabrielgarcia.futhype.dto;

import com.gabrielgarcia.futhype.entities.Produto;

public class ProdutoDTO {
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;


	public ProdutoDTO(Long id, String nome, String descricao, Double preco, String img_url) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = img_url;
	}
	
	public ProdutoDTO(Produto produto) {
		id = produto.getId();
		nome = produto.getNome();
		descricao = produto.getDescricao();
		preco = produto.getPreco();
		imgUrl = produto.getImgUrl();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
	

}
