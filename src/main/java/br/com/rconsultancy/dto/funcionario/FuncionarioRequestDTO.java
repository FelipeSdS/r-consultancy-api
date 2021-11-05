package br.com.rconsultancy.dto.funcionario;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioRequestDTO extends FuncionarioAbstractDTO {

	@JsonProperty("idCliente")
	private Long idCliente;
	
	@JsonProperty("idCargo")
	private Long idCargo;
	
}
