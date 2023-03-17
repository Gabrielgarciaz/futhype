package com.gabrielgarcia.futhype.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidacaoErro extends ErroCustomizado {
	
	private List<MensagemCampo> erros = new ArrayList<>();
	
	public ValidacaoErro(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public List<MensagemCampo> getErros() {
		return erros;
	}
	
	public void addErro(String nomeCampo, String mensagem) {
		erros.add(new MensagemCampo(nomeCampo, mensagem));
	}
}
