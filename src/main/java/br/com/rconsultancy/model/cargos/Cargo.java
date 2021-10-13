package br.com.rconsultancy.model.cargos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.rconsultancy.model.departamentos.Departamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tab_cargo")
public class Cargo {

	@Id
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name= "id_cargo")
	private Long idCargo;
	
	@Column(name = "tx_nome")
	private String txNome;
	
	@Column(name = "tx_descricao")
	private String txDescricao;
	
	@Column(name = "vl_base_salarial")
	private BigDecimal vlBaseSalarial;
	
	@Column(name = "tx_nivel")
	private String txNivel;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;
}
