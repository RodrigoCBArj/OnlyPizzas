package br.com.uninassau.OnlyPizzas.negocio;

import br.com.uninassau.OnlyPizzas.utilidades.Data;
import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

    private String nome;
//    private Endereco endereco;
    private String telefone;
    private String data_nascimento;
    private String data_cadastro = Data.pegarDataAtual();
}
