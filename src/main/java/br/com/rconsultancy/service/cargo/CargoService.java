package br.com.rconsultancy.service.cargo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rconsultancy.dto.cargo.CargoRequestDTO;
import br.com.rconsultancy.dto.cargo.CargoResponseDTO;
import br.com.rconsultancy.mapper.cargo.CargoMapper;
import br.com.rconsultancy.model.cargos.Cargo;
import br.com.rconsultancy.repository.cargo.CargoReposiotry;

@Service
public class CargoService {

	@Autowired
	private CargoReposiotry cargoRepository;
	
	@Autowired
	private CargoMapper cargoMapper;
	
	public void save(CargoRequestDTO dto) {
		Cargo area = cargoMapper.requestToModel(dto);
		cargoRepository.save(area);
	}
	
	public List<CargoResponseDTO> findByClienteId(Long idCliente){
		List<Cargo> areas = cargoRepository.findByDepartamento_idDepartamento(idCliente);
		return areas
				 .stream()
				 .map(x -> cargoMapper.modelToResponse(x))
				 .collect(Collectors.toList());				
	}
}
