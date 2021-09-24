package br.com.rconsultancy.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rconsultancy.model.clientes.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
