package br.com.rconsultancy.mapper.cargo;

import org.mapstruct.Mapper;

import br.com.rconsultancy.dto.cargo.CargoRequestDTO;
import br.com.rconsultancy.dto.cargo.CargoResponseDTO;
import br.com.rconsultancy.model.cargos.Cargo;

@Mapper(componentModel = "spring")
public interface CargoMapper {

	public Cargo requestToModel(CargoRequestDTO dto);
	
	public CargoResponseDTO modelToResponse(Cargo model);
}
