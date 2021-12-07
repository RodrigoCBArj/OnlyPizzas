//package br.com.uninassau.OnlyPizzas.negocio;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "endereco")
//public class Endereco {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia_endereco")
//    private int codigo;
//    private String cep;
//    private String logradouro;
//    private String cidade;
//    private String numero;
//    private String complemento;
//    /*  */
//    @OneToOne
////    @JoinColumn(name = "cliente_codigo")
//    private Cliente cliente;
//
////    public Endereco (String cep, String logradouro, String cidade, String numero, String complemento){
////        this.cep = cep;
////        this.logradouro = logradouro;
////        this.cidade = cidade;
////        this.numero = numero;
////        this.complemento = complemento;
////    }
//}