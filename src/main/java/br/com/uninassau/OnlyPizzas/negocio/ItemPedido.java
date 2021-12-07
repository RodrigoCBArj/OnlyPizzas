//package br.com.uninassau.OnlyPizzas.negocio;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.OneToOne;
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class ItemPedido {
//
//    private Produto produto;
//    private int quantidade;
//    private double valor;
//
//    public ItemPedido(Produto produto, int quantidade) {
//        this.produto = produto;
//        this.quantidade = quantidade;
//        this.valor = Total(quantidade, valor);
//    }
//
//    private static double Total (int quantidade, double valor) {
//        return quantidade * valor;
//    }
//}