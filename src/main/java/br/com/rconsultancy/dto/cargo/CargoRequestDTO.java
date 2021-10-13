package br.com.rconsultancy.dto.cargo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoRequestDTO extends CargoAbstractDTO{

	@JsonProperty("idDepartamento")
	private Long idDepartamento;
}
