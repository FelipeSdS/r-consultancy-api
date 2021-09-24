package br.com.rconsultancy.repository.area;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rconsultancy.model.areas.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>{

	public List<Area> findByCliente_idCliente(Long idCliente);
}
