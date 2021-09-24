package br.com.rconsultancy.controller.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rconsultancy.dto.cliente.ClienteRequestDTO;
import br.com.rconsultancy.dto.cliente.ClienteResponseDTO;
import br.com.rconsultancy.service.cliente.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid ClienteRequestDTO dto) {
		clienteService.save(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idCliente}")
	public ResponseEntity<?> delete(@PathVariable("idCliente") Long idCliente){
		clienteService.delete(idCliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> list(){
		return new ResponseEntity<List<ClienteResponseDTO>>(clienteService.findAll(), HttpStatus.OK);
	}
}
