package br.com.rconsultancy.model.areas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.rconsultancy.model.clientes.Cliente;
import br.com.rconsultancy.model.departamentos.Departamento;
import lombok.Data;

@Data
@Entity
@Table(name = "tab_areas")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_area")
	private Long idArea;
	
	@Column(name="tx_nome")
	private String txNome;
	
	@Column(name="tx_gerente")
	private String txGerente;
	
	@Column(name="tx_email")
	private String txEmail;
	
	@Column(name="tx_descricao")
	private String txDescricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "area", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Departamento> departamentos;
}
