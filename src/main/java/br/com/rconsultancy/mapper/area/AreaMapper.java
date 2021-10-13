package br.com.rconsultancy.mapper.area;

import org.mapstruct.Mapper;

import br.com.rconsultancy.dto.area.AreaRequestDTO;
import br.com.rconsultancy.dto.area.AreaResponseDTO;
import br.com.rconsultancy.model.areas.Area;

@Mapper(componentModel = "spring")
public interface AreaMapper {

	public Area requestToModel(AreaRequestDTO dto);
	
	public AreaResponseDTO modelToResponse(Area model);
}
