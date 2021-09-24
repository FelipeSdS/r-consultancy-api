package br.com.rconsultancy.controller.departamento;

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

import br.com.rconsultancy.dto.departamento.DepartamentoRequestDTO;
import br.com.rconsultancy.dto.departamento.DepartamentoResponseDTO;
import br.com.rconsultancy.service.departamento.DepartamentoService;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody DepartamentoRequestDTO dto){
		departamentoService.save(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/area/{idArea}")
	public ResponseEntity<List<DepartamentoResponseDTO>> findByAreaId(@PathVariable("idArea") Long idArea){
		return new ResponseEntity<List<DepartamentoResponseDTO>>(departamentoService.findByAreaId(idArea), HttpStatus.OK);
	}
}
