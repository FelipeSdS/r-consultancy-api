package br.com.rconsultancy.dto.cargo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public abstract class CargoAbstractDTO {
	
	@JsonProperty("tx_nome")
	private String txNome;
	
	@JsonProperty("tx_descricao")
	private String txDescricao;
	
	@JsonProperty("vl_base_salarial")
	private BigDecimal vlBaseSalarial;
	
	@JsonProperty("tx_nivel")
	private String txNivel;

}
