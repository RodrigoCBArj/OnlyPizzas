package br.com.uninassau.OnlyPizzas.negocio;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia_clientes")
    private int codigo;

//    @OneToMany(mappedBy = "cliente")
//    private List<Pedido> pedidos;

//    @OneToOne(mappedBy = "cliente")
//    @JoinColumn(name = "endereco_codigo", referencedColumnName = "codigo")
//    private Endereco endereco;
}
