package br.com.uninassau.OnlyPizzas.dados;

import br.com.uninassau.OnlyPizzas.negocio.Bebida;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioBebida extends JpaRepository<Bebida, Integer> {
}
