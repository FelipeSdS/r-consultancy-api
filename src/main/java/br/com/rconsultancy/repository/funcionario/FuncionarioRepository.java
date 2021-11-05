package br.com.rconsultancy.repository.funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rconsultancy.model.funcionarios.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	@Query(value = "select f.* from tab_funcionario f " +
			"inner join tab_cargo c " +
			 "on f.id_cargo = c.id_cargo " +
			"inner join tab_departamento d " +
			 "on c.id_departamento = d.id_departamento " +
			"where d.id_departamento = :idDepartamento", nativeQuery = true)
	public List<Funcionario> buscarFunciarioPorDepartamento(@Param("idDepartamento") Long idDepartamento);
	
	@Query(value = "select f.* from tab_funcionario f " +
			"inner join tab_cargo c " +
			 "on f.id_cargo = c.id_cargo " +
			"inner join tab_departamento d " +
			 "on c.id_departamento = d.id_departamento " +
			"inner join tab_area a " +
			 "on d.id_area = a.id_area " +
			"where a.id_area = :idArea", nativeQuery = true)
	public List<Funcionario> buscarFunciarioPorArea(@Param("idArea") Long idArea);
}
