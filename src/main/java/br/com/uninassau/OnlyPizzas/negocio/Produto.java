package br.com.uninassau.OnlyPizzas.negocio;

import br.com.uninassau.OnlyPizzas.utilidades.Data;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Produto {

    private String nome;
    private String descricao;
    private double valor;
    private String data_cadastro = Data.pegarDataAtual();

//    @Override
//    public String toString() {
//        return "\nCódigo: " + this.codigo + "\nNome: " + this.nome + "\nDescrição: " + this.descricao +
//                "\nValor: R$" + this.valor + "\nData de Cadastro: " + this.dataCadastro;
//    }
}
