package br.com.uninassau.OnlyPizzas.negocio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="bebidas")
public class Bebida extends Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia_bebida")
    private int codigo;
    private String volume;
}

