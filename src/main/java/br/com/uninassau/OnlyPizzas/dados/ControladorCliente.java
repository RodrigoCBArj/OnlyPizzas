package br.com.uninassau.OnlyPizzas.dados;

import br.com.uninassau.OnlyPizzas.negocio.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {

    @Autowired
    private RepositorioCliente repositorioCliente;

    @GetMapping    // Lista todas as clientes
    public List<Cliente> listar() {
        return this.repositorioCliente.findAll();
    }

    @PostMapping("/inserir")   // Adiciona uma nova Cliente ao banco de dados. É necessário informar o nome, descrição, valor e tamanho
    public Cliente inserir (@RequestBody Cliente cliente) {
        return this.repositorioCliente.save(cliente);
    }

    @GetMapping("/consultar/{codigo}")    // Mostra a cliente referente ao código informado, caso exista
    public Object consultar(@PathVariable("codigo") int codigo) {

        if (this.repositorioCliente.existsById(codigo)) {
            return this.repositorioCliente.findById(codigo).get();
        } else {
            return "Cliente não encontrada!";
        }
    }

    @PutMapping("/atualizar/{opcao}/{codigo}")    // Atualiza o campo que você deseja, da cliente informada via código
    public Object atualizar(@PathVariable("opcao") int opcao, @PathVariable("codigo") int codigo, @RequestBody Cliente atualizarCliente) {
        Cliente clienteFinal;

        if (this.repositorioCliente.existsById(codigo)) {
            clienteFinal = this.repositorioCliente.getById(codigo);
            if (opcao == 1) {   // 1 - Nome
                clienteFinal.setNome(atualizarCliente.getNome());
            } /*else if (opcao == 2) {    // 2 - Endereco
                clienteFinal.setEndereco(atualizarCliente.getEndereco());
            } */else if (opcao == 3){    // 3 - Telefone
                clienteFinal.setTelefone(atualizarCliente.getTelefone());
            } else if (opcao == 4) {    // 4 - Data_nascimento
                clienteFinal.setData_nascimento(atualizarCliente.getData_nascimento());
            } else {
                return  "Opção inválida!\n" +
                        "Informe da seguinte forma: /cliente/atualizar/{1 ou 2 ou 3 ou 4}/{codigo da cliente}\n" +
                        "Sendo: 1 = nome; 2 = Endereco; 3 = Telefone; 4 = Data_nascimento.";
            }
            return this.repositorioCliente.save(clienteFinal);
        } else {
            return "Cliente inexistente!";
        }
    }

    @DeleteMapping("/remover/{codigo}")   // Deleta uma cliente pelo código, caso exista
    public String remover(@PathVariable("codigo") int codigo) {

        if (this.repositorioCliente.existsById(codigo)) {
            this.repositorioCliente.deleteById(codigo);
            return "Cliente removido com sucesso!";
        } else {
            return "Cliente não encontrado.";
        }
    }
}
