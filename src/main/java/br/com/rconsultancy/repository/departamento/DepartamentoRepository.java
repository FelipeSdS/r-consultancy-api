package br.com.rconsultancy.repository.departamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rconsultancy.model.departamentos.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	public List<Departamento> findByArea_idArea(Long idArea);
}
