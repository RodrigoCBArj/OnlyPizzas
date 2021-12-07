//package br.com.uninassau.OnlyPizzas.negocio;
//
//import javax.persistence.*;
//
//import br.com.uninassau.OnlyPizzas.utilidades.Data;
//import lombok.*;
//
//import java.util.List;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "pedidos")
//public class Pedido {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia_pedido")
//    private int codigo;
//
//    @OneToOne
//    @PrimaryKeyJoinColumn
//    private Cliente cliente;
//
//    @OneToMany
//    @JoinColumn(name = "items_pedido")
//    private List<ItemPedido> produtos;
//
//    private double valor_total;
//    private String data_pedido = Data.pegarDataAtual();
//
////    private double ValorTotalDaCompra(List<ItemPedido> input) {
////        double result = 0;
////        for (ItemPedido item: input){
////            result += item.getValor();
////        }
////        return result;
////    }
//}