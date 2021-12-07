package br.com.uninassau.OnlyPizzas.dados;

import br.com.uninassau.OnlyPizzas.negocio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCliente extends JpaRepository<Cliente, Integer> {
}
