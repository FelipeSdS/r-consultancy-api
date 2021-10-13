package br.com.rconsultancy.mapper.cargo;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rconsultancy.dto.cargo.CargoRequestDTO;
import br.com.rconsultancy.dto.cargo.CargoResponseDTO;
import br.com.rconsultancy.exception.NotRecordFoundException;
import br.com.rconsultancy.model.cargos.Cargo;
import br.com.rconsultancy.model.departamentos.Departamento;
import br.com.rconsultancy.repository.departamento.DepartamentoRepository;

@Component
public class CargoMapperImpl implements CargoMapper{
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public Cargo requestToModel(CargoRequestDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<CargoRequestDTO, Cargo>() {
			@Override
			protected void configure() {
				skip(destination.getIdCargo());
			}
		});
		Cargo model = modelMapper.map(dto, Cargo.class);		
		Departamento departamento = departamentoRepository.findById(dto.getIdDepartamento())
				.orElseThrow(() -> new NotRecordFoundException("Código do departamento inválido."));
		model.setDepartamento(departamento);
		return model;
	}

	@Override
	public CargoResponseDTO modelToResponse(Cargo model) {
		ModelMapper modelMapper = new ModelMapper();
		CargoResponseDTO dto = modelMapper.map(model, CargoResponseDTO.class);
		return dto;
	}

}
