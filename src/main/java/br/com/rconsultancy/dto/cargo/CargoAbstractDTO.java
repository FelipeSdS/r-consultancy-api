package br.com.rconsultancy.dto.cargo;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public abstract class CargoAbstractDTO {
	
	@JsonProperty("txNome")
	private String txNome;
	
	@JsonProperty("txDescricao")
	private String txDescricao;
	
	@JsonProperty("vlBaseSalarial")
	private String vlBaseSalarial;
	
	@JsonProperty("txNivel")
	private String txNivel;

}
