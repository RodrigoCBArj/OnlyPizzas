package br.com.uninassau.OnlyPizzas.dados;

import br.com.uninassau.OnlyPizzas.negocio.Bebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorBebida {

    @Qualifier("repositorioBebida")
    @Autowired
    private RepositorioBebida RepProduto;

    @PostMapping("/bebida/inserir")
    public Bebida inserir (@RequestBody Bebida bebida) {
        return this.RepProduto.save(bebida);
    }

    @GetMapping("/bebida/listar")
    public List<Bebida> listar() {
        return this.RepProduto.findAll();
    }

    @GetMapping("/bebida/consultar/{codigo}")
    public Object consultar(@PathVariable("codigo") int codigo) {

        if (this.RepProduto.existsById(codigo)) {
            return this.RepProduto.findById(codigo);
        } else {
            return "Bebida não encontrada!";
        }
    }

    @PutMapping("/bebida/atualizar/{opcao}/{codigo}")
    public Object atualizar(@PathVariable("codigo") int codigo,@RequestBody Bebida atualizarBebida, @PathVariable("opcao") int opcao) {
        Bebida bebidaFinal;

        if (this.RepProduto.existsById(codigo)) {
            if (opcao == 1) {   // 1 - Nome
                bebidaFinal = this.RepProduto.getById(codigo);
                bebidaFinal.setNome(atualizarBebida.getNome());
            } else if (opcao == 2) {    // 2 - Descrição
                bebidaFinal = this.RepProduto.getById(codigo);
                bebidaFinal.setDescricao(atualizarBebida.getDescricao());
            } else if (opcao == 3){    // 3 - Valor
                bebidaFinal = this.RepProduto.getById(codigo);
                bebidaFinal.setValor(atualizarBebida.getValor());
            } else if (opcao == 4) {    // 4 - Volume
                bebidaFinal = this.RepProduto.getById(codigo);
                bebidaFinal.setVolume(atualizarBebida.getVolume());
            } else {
                return  "Opção inválida!\n" +
                        "Informe da seguinte forma: /bebida/atualizar/{1 ou 2 ou 3 ou 4}/{codigo da bebida}\n" +
                        "Sendo: 1 = nome; 2 = descrição; 3= valor; 4 = volume.";
            }
            return this.RepProduto.save(bebidaFinal);
        } else {
            return "Bebida inexistente!";
        }
    }

    @DeleteMapping("/bebida/remover/{codigo}")
    public String remover(@PathVariable("codigo") int codigo) {

        if (this.RepProduto.existsById(codigo)) {
            this.RepProduto.deleteById(codigo);
            return "Bebida removida com sucesso!";
        } else {
            return "Bebida não encontrada.";
        }
    }
}
