package br.com.rconsultancy.service.cliente;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rconsultancy.dto.cliente.ClienteRequestDTO;
import br.com.rconsultancy.dto.cliente.ClienteResponseDTO;
import br.com.rconsultancy.exception.NotRecordFoundException;
import br.com.rconsultancy.model.clientes.Cliente;
import br.com.rconsultancy.repository.cliente.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void save(ClienteRequestDTO dto) {
		Cliente cliente = convertModel(dto);
		clienteRepository.save(cliente);
	}
	
	public void delete(Long idCliente) {
		Cliente cliente = clienteRepository.findById(idCliente)
			.orElseThrow(() -> new NotRecordFoundException("Cliente não encontrado ou não existente."));
		clienteRepository.delete(cliente);
	}
	
	public List<ClienteResponseDTO> findAll(){
		return clienteRepository.findAll()
				.stream()
				.map(x -> convertResponse(x))
				.collect(Collectors.toList());
	}
	
	private Cliente convertModel(ClienteRequestDTO dto) {
		Cliente model = modelMapper.map(dto, Cliente.class);
		return model;
	}
	
	private ClienteResponseDTO convertResponse(Cliente cliente) {
		ClienteResponseDTO dto = modelMapper.map(cliente, ClienteResponseDTO.class);
		return dto;
	}
}
