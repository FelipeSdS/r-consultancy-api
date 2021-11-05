package br.com.rconsultancy.mapper.funcionario;

import org.mapstruct.Mapper;

import br.com.rconsultancy.dto.funcionario.FuncionarioRequestDTO;
import br.com.rconsultancy.dto.funcionario.FuncionarioResponseDTO;
import br.com.rconsultancy.model.funcionarios.Funcionario;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

	public Funcionario requestToModel(FuncionarioRequestDTO request);
	
	public FuncionarioResponseDTO modelToResponse(Funcionario model);
}
