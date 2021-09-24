package br.com.rconsultancy.dto.departamento;


import lombok.Data;

@Data
public abstract class DepartamentoAbstractDTO {
	
	private String txNome;
	
	private String txResponsavel;
	
	private String txEmail;
	
	private String txDescricao;
	
}
