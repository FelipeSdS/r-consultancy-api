package br.com.rconsultancy.service.funcionario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rconsultancy.dto.funcionario.FuncionarioRequestDTO;
import br.com.rconsultancy.dto.funcionario.FuncionarioResponseDTO;
import br.com.rconsultancy.mapper.funcionario.FuncionarioMapper;
import br.com.rconsultancy.model.funcionarios.Funcionario;
import br.com.rconsultancy.repository.funcionario.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioMapper funcionarioMapper;
	
	public FuncionarioResponseDTO save(FuncionarioRequestDTO request) {
		Funcionario model = funcionarioMapper.requestToModel(request);
		funcionarioRepository.save(model);
		return funcionarioMapper.modelToResponse(model);
	}
	
	public List<FuncionarioResponseDTO> findByDepartamentoId(Long idDepartamento){
		return funcionarioRepository.buscarFunciarioPorDepartamento(idDepartamento)
				.stream()
				.map(x -> funcionarioMapper.modelToResponse(x))
				.collect(Collectors.toList());			
	}
	
	public List<FuncionarioResponseDTO> findByAreaId(Long idArea){
		return funcionarioRepository.buscarFunciarioPorArea(idArea)
				.stream()
				.map(x -> funcionarioMapper.modelToResponse(x))
				.collect(Collectors.toList());			
	}
	
}
