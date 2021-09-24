package br.com.rconsultancy.service.departamento;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rconsultancy.dto.departamento.DepartamentoRequestDTO;
import br.com.rconsultancy.dto.departamento.DepartamentoResponseDTO;
import br.com.rconsultancy.model.departamentos.Departamento;
import br.com.rconsultancy.repository.departamento.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void save(DepartamentoRequestDTO dto) {
		Departamento departamento = convertModel(dto);
		departamentoRepository.save(departamento);
	}
	
	public List<DepartamentoResponseDTO> findByAreaId(Long idArea){
		List<Departamento> departamentos = departamentoRepository.findByArea_idArea(idArea);
		return departamentos
				 .stream()
				 .map(x -> convertResponse(x))
				 .collect(Collectors.toList());
					
	}
	
	private Departamento convertModel(DepartamentoRequestDTO dto) {
		Departamento model = modelMapper.map(dto, Departamento.class);
		return model;
	}
	
	private DepartamentoResponseDTO convertResponse(Departamento departamento) {
		DepartamentoResponseDTO dto = modelMapper.map(departamento, DepartamentoResponseDTO.class);
		return dto;
	}
}
