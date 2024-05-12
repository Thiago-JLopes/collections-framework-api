package List.Ordenacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
        System.out.println("Lista de pessoas vazia foi criada com sucesso.");
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome,idade,altura));
        System.out.println(nome + " foi adidionado(a) a lista com sucesso.");
    }

    public List<Pessoa> ordenarPrioridade() {
        List<Pessoa>pessoaPorIdade = new ArrayList<>(pessoaList);

        if(pessoaList.isEmpty()) {
            throw new RuntimeException("A lista está vazia.");
        } else {
            Collections.sort(pessoaPorIdade);
            return pessoaPorIdade;
        }
    }

    public List<Pessoa>ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);

        if(pessoaList.isEmpty()) {
            throw new RuntimeException("A Lista está vazia.");
        } else {
            Collections.sort(pessoasPorAltura, new ComparadorPorAltura());
            return pessoasPorAltura;
        }
    }

    public static void main(String[] args) {
        OrdenacaoPessoa pessoas = new OrdenacaoPessoa();
        pessoas.adicionarPessoa("Thiago", 25, 1.74);
        pessoas.adicionarPessoa("Maria", 29, 2.04);
        pessoas.adicionarPessoa("João", 36, 1.90);
        pessoas.adicionarPessoa("Thel", 14, 1.58);
        pessoas.adicionarPessoa("Túlio", 27, 1.64);

        System.out.println("A lista ordenada por Idade: " + pessoas.ordenarPrioridade());
        System.out.println("A lista ordenada por Altura: " + pessoas.ordenarPorAltura());
    }
}
