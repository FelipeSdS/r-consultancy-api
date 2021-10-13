package br.com.rconsultancy.mapper.area;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rconsultancy.dto.area.AreaRequestDTO;
import br.com.rconsultancy.dto.area.AreaResponseDTO;
import br.com.rconsultancy.exception.NotRecordFoundException;
import br.com.rconsultancy.model.areas.Area;
import br.com.rconsultancy.model.clientes.Cliente;
import br.com.rconsultancy.repository.cliente.ClienteRepository;

@Component
public class AreaMapperImpl implements AreaMapper{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Area requestToModel(AreaRequestDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<AreaRequestDTO, Area>() {
			@Override
			protected void configure() {
				skip(destination.getIdArea());
			}
		});
		Area model = modelMapper.map(dto, Area.class);
		Cliente cliente = clienteRepository.findById(dto.getIdCliente())
				.orElseThrow(() -> new NotRecordFoundException("Código cliente inválido."));	
		model.setCliente(cliente);	
		return model;
	}


	@Override
	public AreaResponseDTO modelToResponse(Area model) {
		ModelMapper modelMapper = new ModelMapper();
		AreaResponseDTO dto = modelMapper.map(model, AreaResponseDTO.class);
		return dto;
	}
}
