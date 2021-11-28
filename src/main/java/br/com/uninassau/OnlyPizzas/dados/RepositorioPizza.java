package br.com.uninassau.OnlyPizzas.dados;

import br.com.uninassau.OnlyPizzas.negocio.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPizza extends JpaRepository<Pizza, Integer> {

//    @Query("SELECT g FROM pizzas g WHERE g.tamanho = :tamanho")
//    public List<Pizza> tamGrande (@PathParam("tamanho") String tamanho);

//    public List<Pizza> findByTamanhoGreaterThan(String tamanho);  // via spring jpa
}
