package br.com.rconsultancy.dto.area;

import lombok.Data;

@Data
public abstract class AreaAbstractDTO {

	private String txNome;
	
	private String txGerente;
	
	private String txEmail;
	
	private String txDescricao;
}
