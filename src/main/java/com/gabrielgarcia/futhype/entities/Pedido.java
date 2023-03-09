package com.gabrielgarcia.futhype.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition =  "TIMESTAMP WITHOUT TIME ZONE")
	private Instant momento;
	private PedidoStatus status;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
}
