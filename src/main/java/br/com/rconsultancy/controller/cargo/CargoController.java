package br.com.rconsultancy.controller.cargo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rconsultancy.dto.cargo.CargoRequestDTO;
import br.com.rconsultancy.dto.cargo.CargoResponseDTO;
import br.com.rconsultancy.service.cargo.CargoService;

@RestController
@RequestMapping("cargo")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CargoRequestDTO dto){
		cargoService.save(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/departamento/{idDepartamento}")
	public ResponseEntity<List<CargoResponseDTO>> findByDepartamento(@PathVariable("idDepartamento") Long idDepartamento){
		return new ResponseEntity<List<CargoResponseDTO>>(cargoService.findByClienteId(idDepartamento), HttpStatus.OK);
	}
}
