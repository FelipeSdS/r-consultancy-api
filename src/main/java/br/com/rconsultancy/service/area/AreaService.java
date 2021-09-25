package br.com.rconsultancy.service.area;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rconsultancy.dto.area.AreaRequestDTO;
import br.com.rconsultancy.dto.area.AreaResponseDTO;
import br.com.rconsultancy.exception.NotRecordFoundException;
import br.com.rconsultancy.model.areas.Area;
import br.com.rconsultancy.model.clientes.Cliente;
import br.com.rconsultancy.repository.area.AreaRepository;
import br.com.rconsultancy.repository.cliente.ClienteRepository;

@Service
public class AreaService {

	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void save(AreaRequestDTO dto) {
		Area area = convertModel(dto);
		areaRepository.save(area);
	}
	
	public List<AreaResponseDTO> findByClienteId(Long idCliente){
		List<Area> areas = areaRepository.findByCliente_idCliente(idCliente);
		return areas
				 .stream()
				 .map(x -> convertResponse(x))
				 .collect(Collectors.toList());				
	}
	
	private Area convertModel(AreaRequestDTO dto) {
		Area model = modelMapper.map(dto, Area.class);	
		Cliente cliente = clienteRepository.findById(dto.getIdCliente())
				.orElseThrow(() -> new NotRecordFoundException("Código cliente inválido."));	
		model.setCliente(cliente);	
		return model;
	}
	
	private AreaResponseDTO convertResponse(Area model) {
		AreaResponseDTO dto = modelMapper.map(model, AreaResponseDTO.class);
		return dto;
	}
}
