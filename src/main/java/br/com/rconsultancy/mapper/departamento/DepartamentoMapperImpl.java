package br.com.rconsultancy.mapper.departamento;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rconsultancy.dto.departamento.DepartamentoRequestDTO;
import br.com.rconsultancy.dto.departamento.DepartamentoResponseDTO;
import br.com.rconsultancy.exception.NotRecordFoundException;
import br.com.rconsultancy.model.areas.Area;
import br.com.rconsultancy.model.departamentos.Departamento;
import br.com.rconsultancy.repository.area.AreaRepository;

@Component
public class DepartamentoMapperImpl implements DepartamentoMapper{
	
	@Autowired
	private AreaRepository areaRepository;

	@Override
	public Departamento requestToModel(DepartamentoRequestDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<DepartamentoRequestDTO, Departamento>() {
			@Override
			protected void configure() {
				skip(destination.getIdDepartamento());
			}
		});
		Departamento model = modelMapper.map(dto, Departamento.class);		
		Area area = areaRepository.findById(dto.getIdArea())
				.orElseThrow(() -> new NotRecordFoundException("Código da area inválido."));
		model.setArea(area);
		return model;
	}

	public DepartamentoResponseDTO modelToResponse(Departamento model) {
		ModelMapper modelMapper = new ModelMapper();
		DepartamentoResponseDTO dto = modelMapper.map(model, DepartamentoResponseDTO.class);
		return dto;
	}
}
