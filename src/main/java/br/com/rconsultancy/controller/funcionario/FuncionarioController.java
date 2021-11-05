package br.com.rconsultancy.controller.funcionario;

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

import br.com.rconsultancy.dto.funcionario.FuncionarioRequestDTO;
import br.com.rconsultancy.dto.funcionario.FuncionarioResponseDTO;
import br.com.rconsultancy.service.funcionario.FuncionarioService;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	public ResponseEntity<FuncionarioResponseDTO> create(@RequestBody FuncionarioRequestDTO request){
		return new ResponseEntity<FuncionarioResponseDTO>(funcionarioService.save(request), HttpStatus.OK);
	}
	
	@GetMapping("/departamento/{idDepartamento}")
	public ResponseEntity<List<FuncionarioResponseDTO>> findByDepartamentoId(@PathVariable("idDepartamento") Long idDepartamento){
		return new ResponseEntity<List<FuncionarioResponseDTO>>(funcionarioService.findByDepartamentoId(idDepartamento), HttpStatus.OK);
	}
	
	@GetMapping("/area/{idArea}")
	public ResponseEntity<List<FuncionarioResponseDTO>> findByAreaId(@PathVariable("idArea") Long idArea){
		return new ResponseEntity<List<FuncionarioResponseDTO>>(funcionarioService.findByAreaId(idArea), HttpStatus.OK);
	}
}
