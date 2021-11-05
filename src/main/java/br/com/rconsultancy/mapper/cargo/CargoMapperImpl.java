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
import br.com.rconsultancy.util.Document;

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
				skip(destination.getVlBaseSalarial());
			}
		});
		Cargo model = modelMapper.map(dto, Cargo.class);	
		model.setVlBaseSalarial(Document.valueStringToValueBigDecimal(dto.getVlBaseSalarial()));
		Departamento departamento = departamentoRepository.findById(dto.getIdDepartamento())
				.orElseThrow(() -> new NotRecordFoundException("Código do departamento inválido."));
		model.setDepartamento(departamento);
		return model;
	}

	@Override
	public CargoResponseDTO modelToResponse(Cargo model) {
		ModelMapper modelMapper = new ModelMapper();
		CargoResponseDTO dto = modelMapper.map(model, CargoResponseDTO.class);
		StringBuilder cargonivel = new StringBuilder();
		cargonivel.append(model.getTxNome()).append(" - ").append(model.getTxNivel());
		dto.setTxCargoNivel(cargonivel.toString());
		return dto;
	}

}
