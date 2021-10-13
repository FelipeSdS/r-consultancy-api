package br.com.rconsultancy.repository.cargo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rconsultancy.model.cargos.Cargo;

@Repository
public interface CargoReposiotry extends JpaRepository<Cargo, Long>{

	public List<Cargo> findByDepartamento_idDepartamento(Long idDepartamento);
}
