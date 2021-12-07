package br.com.uninassau.OnlyPizzas.negocio;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia_clientes")
    private int codigo;

    @OneToMany(mappedBy = "cliente")
    @JoinColumn(name = "pedidos_codigo")
    private Pedido pedidos;
}
