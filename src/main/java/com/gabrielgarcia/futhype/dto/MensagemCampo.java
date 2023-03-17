package com.gabrielgarcia.futhype.dto;

public class MensagemCampo {
	
	private String nomeCampo;
	private String mensagem;
	 
	public MensagemCampo(String nomeCampo, String mensagem) {
		this.nomeCampo = nomeCampo;
		this.mensagem = mensagem;
	}
	public String getNomeCampo() {
		return nomeCampo;
	}
	public String getMensagem() {
		return mensagem;
	}
	
	

}
