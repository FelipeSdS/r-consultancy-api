package br.com.rconsultancy.controller.area;

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

import br.com.rconsultancy.dto.area.AreaRequestDTO;
import br.com.rconsultancy.dto.area.AreaResponseDTO;
import br.com.rconsultancy.service.area.AreaService;

@RestController
@RequestMapping("area")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AreaRequestDTO dto){
		areaService.save(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/cliente/{idCliente}")
	public ResponseEntity<List<AreaResponseDTO>> findByCliente(@PathVariable("idCliente") Long idCliente){
		return new ResponseEntity<List<AreaResponseDTO>>(areaService.findByClienteId(idCliente), HttpStatus.OK);
	}
}
