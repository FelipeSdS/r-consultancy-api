package br.com.rconsultancy.mapper.departamento;

import org.mapstruct.Mapper;

import br.com.rconsultancy.dto.departamento.DepartamentoRequestDTO;
import br.com.rconsultancy.dto.departamento.DepartamentoResponseDTO;
import br.com.rconsultancy.model.departamentos.Departamento;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {

	public Departamento requestToModel(DepartamentoRequestDTO dto);
	
	public DepartamentoResponseDTO modelToResponse(Departamento departamento);
}
