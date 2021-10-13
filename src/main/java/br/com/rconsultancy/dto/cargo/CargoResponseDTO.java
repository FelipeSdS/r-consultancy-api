package br.com.rconsultancy.dto.cargo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoResponseDTO extends CargoAbstractDTO{

	@JsonProperty("idCargo")
	private Long idCargo;
}
