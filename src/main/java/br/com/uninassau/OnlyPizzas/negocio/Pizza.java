package br.com.uninassau.OnlyPizzas.negocio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pizzas")
public class Pizza extends Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia_pizza")
    private int codigo;
    private String tamanho;
}
