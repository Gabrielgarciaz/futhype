package com.gabrielgarcia.futhype.dto;

import com.gabrielgarcia.futhype.entities.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProdutoDTO {
	private Long id;
	
	@Size(min = 3, max = 80, message = "Nome deve ter de 3 a 80 caracteres")
	@NotBlank(message = "Preencha o campo 'nome'") // Verificar se não está vazio, não aceita se colocar só espaço em branco
	private String nome;
	@Size(min = 10, message = "A descrição não pode ter menos de 10 caracteres")
	@NotBlank
	private String descricao;
	@Positive(message = "O Preço deve ser positivo.")
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
