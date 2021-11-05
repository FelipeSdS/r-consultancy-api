package br.com.rconsultancy.model.funcionarios;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.rconsultancy.model.cargos.Cargo;
import br.com.rconsultancy.model.clientes.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tab_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "id_funcionario")
	private Long idFuncionario;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	
	@Column(name="tx_nome")
	private String txNome;
	
	@Column(name="tx_sobrenome")
	private String txSobrenome;
	
	@Column(name="tx_cpf")
	private String txCpf;
	
	@Column(name="dt_nascimento")
	private LocalDate dtNascimento;
	
	@Column(name="cd_cep")
    private Long cdCep;
	
	@Column(name="tx_logradouro")
    private String txLogradouro;
	
	@Column(name="cd_numero")
    private Long cdNumero;
	
	@Column(name="tx_bairro")
    private String txBairro;
	
	@Column(name="tx_complemento")
    private String txComplemento;
	
	@Column(name="tx_cidade")
    private String txCidade;
	
	@Column(name="tx_uf")
    private String txUf;
	
	@Column(name="tx_pais")
    private String txPais;
	
	@Column(name="vl_complemento_salario")
    private BigDecimal vlComplementoSalario;
    
	@Column(name="ck_vale_alimentacao")
    private Boolean ckValeAlimentacao;
    
	@Column(name="ck_vale_refeicao")
    private Boolean ckValeRefeicao;
    
	@Column(name="ck_convenio")
    private Boolean ckConvenio;
}
