package br.com.uninassau.OnlyPizzas.dados;

import br.com.uninassau.OnlyPizzas.negocio.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorPizza {

    @Qualifier("repositorioPizza")
    @Autowired
    private RepositorioPizza RepProduto;

    @PostMapping("/pizza/inserir")
    public Pizza inserir (@RequestBody Pizza pizza) {
        return this.RepProduto.save(pizza);
    }

    @GetMapping("/pizza/listar")
    public List<Pizza> listar() {
        return this.RepProduto.findAll();
    }

    @GetMapping("/pizza/consultar/{codigo}")
    public Object consultar(@PathVariable("codigo") int codigo) {

        if (this.RepProduto.existsById(codigo)) {
            return this.RepProduto.findById(codigo);
        } else {
            return "Pizza não encontrada!";
        }
    }

    @PutMapping("/pizza/atualizar/{opcao}/{codigo}")
    public Object atualizar(@PathVariable("opcao") int opcao, @PathVariable("codigo") int codigo, @RequestBody Pizza atualizarPizza) {
        Pizza pizzaFinal;

        if (this.RepProduto.existsById(codigo)) {
            if (opcao == 1) {   // 1 - Nome
                pizzaFinal = this.RepProduto.getById(codigo);
                pizzaFinal.setNome(atualizarPizza.getNome());
            } else if (opcao == 2) {    // 2 - Descrição
                pizzaFinal = this.RepProduto.getById(codigo);
                pizzaFinal.setDescricao(atualizarPizza.getDescricao());
            } else if (opcao == 3){    // 3 - Valor
                pizzaFinal = this.RepProduto.getById(codigo);
                pizzaFinal.setValor(atualizarPizza.getValor());
            } else if (opcao == 4) {    // Tamanho
                pizzaFinal = this.RepProduto.getById(codigo);
                pizzaFinal.setTamanho(atualizarPizza.getTamanho());
            } else {
                return  "Opção inválida!\n" +
                        "Informe da seguinte forma: /pizza/atualizar/{1 ou 2 ou 3 ou 4}/{codigo da pizza}\n" +
                        "Sendo: 1 = nome; 2 = descrição; 3= valor; 4 = tamanho.";
            }
            return this.RepProduto.save(pizzaFinal);
        } else {
            return "Pizza inexistente!";
        }
    }

    @DeleteMapping("/pizza/remover/{codigo}")
    public String remover(@PathVariable("codigo") int codigo) {

        if (this.RepProduto.existsById(codigo)) {
            this.RepProduto.deleteById(codigo);
            return "Pizza removida com sucesso!";
        } else {
            return "Pizza não encontrada.";
        }
    }
}
