package br.com.rconsultancy.service.area;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rconsultancy.dto.area.AreaRequestDTO;
import br.com.rconsultancy.dto.area.AreaResponseDTO;
import br.com.rconsultancy.mapper.area.AreaMapper;
import br.com.rconsultancy.model.areas.Area;
import br.com.rconsultancy.repository.area.AreaRepository;

@Service
public class AreaService {

	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private AreaMapper areaMapper;
	
	public void save(AreaRequestDTO dto) {
		Area area = areaMapper.requestToModel(dto);
		areaRepository.save(area);
	}
	
	public List<AreaResponseDTO> findByClienteId(Long idCliente){
		List<Area> areas = areaRepository.findByCliente_idCliente(idCliente);
		return areas
				 .stream()
				 .map(x -> areaMapper.modelToResponse(x))
				 .collect(Collectors.toList());				
	}

}
