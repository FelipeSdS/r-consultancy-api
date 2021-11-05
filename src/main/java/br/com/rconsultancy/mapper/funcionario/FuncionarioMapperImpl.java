package br.com.rconsultancy.mapper.funcionario;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rconsultancy.dto.funcionario.FuncionarioRequestDTO;
import br.com.rconsultancy.dto.funcionario.FuncionarioResponseDTO;
import br.com.rconsultancy.exception.NotRecordFoundException;
import br.com.rconsultancy.model.cargos.Cargo;
import br.com.rconsultancy.model.clientes.Cliente;
import br.com.rconsultancy.model.funcionarios.Funcionario;
import br.com.rconsultancy.repository.cargo.CargoReposiotry;
import br.com.rconsultancy.repository.cliente.ClienteRepository;
import br.com.rconsultancy.util.Document;

@Component
public class FuncionarioMapperImpl implements FuncionarioMapper{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CargoReposiotry cargoRepository;

	@Override
	public Funcionario requestToModel(FuncionarioRequestDTO request) {
		Funcionario model = new Funcionario();
		model.setTxNome(request.getTxNome());
		model.setTxSobrenome(request.getTxSobrenome());
		model.setTxCpf(request.getTxCpf());
		model.setDtNascimento(request.getDtNascimento());
		model.setCdCep(request.getCdCep());
		model.setTxLogradouro(request.getTxLogradouro());
		model.setCdNumero(request.getCdNumero());
		model.setTxBairro(request.getTxBairro());
		model.setTxComplemento(request.getTxComplemento());
		model.setTxCidade(request.getTxCidade());
		model.setTxUf(request.getTxUf());
		model.setTxPais(request.getTxPais());
		model.setCkConvenio(request.getCkConvenio());
		model.setCkValeAlimentacao(request.getCkValeAlimentacao());
		model.setCkValeRefeicao(request.getCkValeRefeicao());
		model.setVlComplementoSalario(Document.valueStringToValueBigDecimal(request.getTxComplementoSalario()));
		Cliente cliente = clienteRepository.findById(request.getIdCliente())
			.orElseThrow(() -> new NotRecordFoundException("Código cliente inválido."));
		Cargo cargo = cargoRepository.findById(request.getIdCargo())
			.orElseThrow(() -> new NotRecordFoundException("Código cargo inválido."));
		model.setCliente(cliente);
		model.setCargo(cargo);
		return model;
	}

	@Override
	public FuncionarioResponseDTO modelToResponse(Funcionario model) {
		ModelMapper modelMapper = new ModelMapper();
		FuncionarioResponseDTO response = modelMapper.map(model, FuncionarioResponseDTO.class);
		return response;
	}

}
