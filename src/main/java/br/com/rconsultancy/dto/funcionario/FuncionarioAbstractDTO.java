package br.com.rconsultancy.dto.funcionario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public abstract class FuncionarioAbstractDTO {
	
	@JsonProperty("txNome")
	private String txNome;
	
	@JsonProperty("txSobrenome")
	private String txSobrenome;
	
	@JsonProperty("txCpf")
	private String txCpf;
	
	@JsonProperty("dtNascimento")
	private LocalDate dtNascimento;
	
	@JsonProperty("cdCep")
    private Long cdCep;
	
	@JsonProperty("txLogradouro")
    private String txLogradouro;
	
	@JsonProperty("cdNumero")
    private Long cdNumero;
	
	@JsonProperty("txBairro")
    private String txBairro;
	
	@JsonProperty("txComplemento")
    private String txComplemento;
	
	@JsonProperty("txCidade")
    private String txCidade;
	
	@JsonProperty("txUf")
    private String txUf;
	
	@JsonProperty("txPais")
    private String txPais;
	
	@JsonProperty("txComplementoSalario")
    private String txComplementoSalario;
    
	@JsonProperty("ckValeAlimentacao")
    private Boolean ckValeAlimentacao;
    
	@JsonProperty("ckValeRefeicao")
    private Boolean ckValeRefeicao;
    
	@JsonProperty("ckConvenio")
    private Boolean ckConvenio;
	
}
