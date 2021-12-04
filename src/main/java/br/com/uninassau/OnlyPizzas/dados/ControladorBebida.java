package br.com.uninassau.OnlyPizzas.dados;

import br.com.uninassau.OnlyPizzas.negocio.Bebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class ControladorBebida {

    @Autowired
    private RepositorioBebida repositorioBebida;

    @GetMapping   // Lista todas as bebidas
    public List<Bebida> listar() {
        return this.repositorioBebida.findAll();
    }

    @PostMapping("/inserir")   // Adiciona uma nova bebida ao banco de dados. É necessário informar o nome, descrição, valor e volume
    public Bebida inserir (@RequestBody Bebida bebida) {
        return this.repositorioBebida.save(bebida);
    }

    @GetMapping("/consultar/{codigo}")    // Mostra a bebida referente ao código informado, caso exista
    public Object consultar(@PathVariable("codigo") int codigo) {

        if (this.repositorioBebida.existsById(codigo)) {
            return this.repositorioBebida.findById(codigo).get();
        } else {
            return "Bebida não encontrada!";
        }
    }

    @PutMapping("/atualizar/{opcao}/{codigo}")    // Atualiza o campo que você deseja, da bebida informada via código
    public Object atualizar(@PathVariable("codigo") int codigo,@RequestBody Bebida atualizarBebida, @PathVariable("opcao") int opcao) {
        Bebida bebidaFinal;

        if (this.repositorioBebida.existsById(codigo)) {
            if (opcao == 1) {   // 1 - Nome
                bebidaFinal = this.repositorioBebida.getById(codigo);
                bebidaFinal.setNome(atualizarBebida.getNome());
            } else if (opcao == 2) {    // 2 - Descrição
                bebidaFinal = this.repositorioBebida.getById(codigo);
                bebidaFinal.setDescricao(atualizarBebida.getDescricao());
            } else if (opcao == 3){    // 3 - Valor
                bebidaFinal = this.repositorioBebida.getById(codigo);
                bebidaFinal.setValor(atualizarBebida.getValor());
            } else if (opcao == 4) {    // 4 - Volume
                bebidaFinal = this.repositorioBebida.getById(codigo);
                bebidaFinal.setVolume(atualizarBebida.getVolume());
            } else {
                return  "Opção inválida!\n" +
                        "Informe da seguinte forma: /bebida/atualizar/{1 ou 2 ou 3 ou 4}/{codigo da bebida}\n" +
                        "Sendo: 1 = nome; 2 = descrição; 3 = valor; 4 = volume.";
            }
            return this.repositorioBebida.save(bebidaFinal);
        } else {
            return "Bebida inexistente!";
        }
    }

    @DeleteMapping("/remover/{codigo}")   // Deleta uma bebida pelo código, caso exista
    public String remover(@PathVariable("codigo") int codigo) {

        if (this.repositorioBebida.existsById(codigo)) {
            this.repositorioBebida.deleteById(codigo);
            return "Bebida removida com sucesso!";
        } else {
            return "Bebida não encontrada.";
        }
    }
}