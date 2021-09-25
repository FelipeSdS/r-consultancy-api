package br.com.rconsultancy.model.departamentos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.rconsultancy.model.areas.Area;
import lombok.Data;

@Data
@Entity
@Table(name="tab_departamento")
public class Departamento {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id_departamento")
	private Long idDepartamento;
	
	@Column(name="tx_nome")
	private String txNome;
	
	@Column(name="tx_responsavel")
	private String txResponsavel;
	
	@Column(name="tx_email")
	private String txEmail;
	
	@Column(name="tx_descricao")
	private String txDescricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area")
	private Area area;
	
}
