package br.com.rconsultancy.service.departamento;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rconsultancy.dto.departamento.DepartamentoRequestDTO;
import br.com.rconsultancy.dto.departamento.DepartamentoResponseDTO;
import br.com.rconsultancy.mapper.departamento.DepartamentoMapper;
import br.com.rconsultancy.model.departamentos.Departamento;
import br.com.rconsultancy.repository.departamento.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private DepartamentoMapper departamentoMapper;
	
	public void save(DepartamentoRequestDTO dto) {
		Departamento departamento = departamentoMapper.requestToModel(dto);
		departamentoRepository.save(departamento);
	}
	
	public List<DepartamentoResponseDTO> findByAreaId(Long idArea){
		List<Departamento> departamentos = departamentoRepository.findByArea_idArea(idArea);
		return departamentos
				 .stream()
				 .map(x -> departamentoMapper.modelToResponse(x))
				 .collect(Collectors.toList());					
	}
}
