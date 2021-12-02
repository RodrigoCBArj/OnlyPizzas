package br.com.uninassau.OnlyPizzas.dados;

import br.com.uninassau.OnlyPizzas.negocio.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class ControladorPizza {

    @Autowired
    private RepositorioPizza repositorioPizza;

    @GetMapping    // Lista todas as pizzas
    public List<Pizza> listar() {
        return this.repositorioPizza.findAll();
    }

    @PostMapping("/inserir")   // Adiciona uma nova pizza ao banco de dados. É necessário informar o nome, descrição, valor e tamanho
    public Pizza inserir (@RequestBody Pizza pizza) {
        return this.repositorioPizza.save(pizza);
    }

    @GetMapping("/consultar/{codigo}")    // Mostra a pizza referente ao código informado, caso exista
    public Object consultar(@PathVariable("codigo") int codigo) {

        if (this.repositorioPizza.existsById(codigo)) {
            return this.repositorioPizza.findById(codigo);
        } else {
            return "Pizza não encontrada!";
        }
    }

    @PutMapping("/atualizar/{opcao}/{codigo}")    // Atualiza o campo que você deseja, da pizza informada via código
    public Object atualizar(@PathVariable("opcao") int opcao, @PathVariable("codigo") int codigo, @RequestBody Pizza atualizarPizza) {
        Pizza pizzaFinal;

        if (this.repositorioPizza.existsById(codigo)) {
            if (opcao == 1) {   // 1 - Nome
                pizzaFinal = this.repositorioPizza.getById(codigo);
                pizzaFinal.setNome(atualizarPizza.getNome());
            } else if (opcao == 2) {    // 2 - Descrição
                pizzaFinal = this.repositorioPizza.getById(codigo);
                pizzaFinal.setDescricao(atualizarPizza.getDescricao());
            } else if (opcao == 3){    // 3 - Valor
                pizzaFinal = this.repositorioPizza.getById(codigo);
                pizzaFinal.setValor(atualizarPizza.getValor());
            } else if (opcao == 4) {    // Tamanho
                pizzaFinal = this.repositorioPizza.getById(codigo);
                pizzaFinal.setTamanho(atualizarPizza.getTamanho());
            } else {
                return  "Opção inválida!\n" +
                        "Informe da seguinte forma: /pizza/atualizar/{1 ou 2 ou 3 ou 4}/{codigo da pizza}\n" +
                        "Sendo: 1 = nome; 2 = descrição; 3 = valor; 4 = tamanho.";
            }
            return this.repositorioPizza.save(pizzaFinal);
        } else {
            return "Pizza inexistente!";
        }
    }

    @DeleteMapping("/remover/{codigo}")   // Deleta uma pizza pelo código, caso exista
    public String remover(@PathVariable("codigo") int codigo) {

        if (this.repositorioPizza.existsById(codigo)) {
            this.repositorioPizza.deleteById(codigo);
            return "Pizza removida com sucesso!";
        } else {
            return "Pizza não encontrada.";
        }
    }
}
