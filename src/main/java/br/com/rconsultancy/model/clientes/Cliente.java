package br.com.rconsultancy.model.clientes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.rconsultancy.model.areas.Area;
import br.com.rconsultancy.model.funcionarios.Funcionario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tab_cliente")
public class Cliente {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Column(name="tx_razao_social")
    private String txRazaoSocial;
    
	@Column(name="tx_nome_fantasia")
    private String txNomeFantasia;
    
	@Column(name="tx_nome_simples")
    private String txNomeSimples; 
    
	@Column(name="tx_cpf")
    private String txCpf; 
    
	@Column(name="tx_cnpj")
    private String txCnpj; 
    
	@Column(name="tx_cep")
    private String txCep; 
    
	@Column(name="tx_logradouro")
    private String txLogradouro; 
    
	@Column(name="vl_numero")
    private Long vlNumero; 
    
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
    
	@Column(name="tx_telefone")
    private String txTelefone; 
    
	@Column(name="tx_email")
    private String txEmail; 
    
	@Column(name="tx_website")
    private String txWebSite;
    
	@Column(name="tx_area_negocios")
    private String txAreaNegocios;  
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Area> areas;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Funcionario> funcionarios;
}
