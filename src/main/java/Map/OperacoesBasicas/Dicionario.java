package Map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String,String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
        System.out.println("Dicionário vazio criado com sucesso.");
    }

    void adicionarPalavra(String palavra, String descricao) {
        dicionario.put(palavra,descricao);
    }

    void removerPalavra(String palavra) {
        if(dicionario.isEmpty()) {
            throw new RuntimeException("Dicionário vazio.");
        } else {
            if(dicionario.containsKey(palavra)) {
                dicionario.remove(palavra);
                System.out.println("Palavra removida com sucesso.");
            } else {
                System.out.println("A palavra não está contida no dicionário.");
            }
        }
    }

    void exibirPalavras() {
        if(dicionario.isEmpty()) {
            throw new RuntimeException("dicionário vazio.");
        } else {
            System.out.println(dicionario);
        }
    }

    void pesquisarPorPalavras(String palavra) {
        if (dicionario.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio.");
        } else {
            if (dicionario.containsKey(palavra)) {
                System.out.println("O significado da palavra " + palavra + ":  " + dicionario.get(palavra));
            } else {
                System.out.println("A palavra não está contida no dicionário.");
            }
        }
    }

    @Override
    public String toString() {
        return "dicionario=" + dicionario;
    }

    public static void main(String[] args) {
        Dicionario dicionario1 = new Dicionario();
        dicionario1.adicionarPalavra("teste1", "descrição do teste1");
        dicionario1.adicionarPalavra("teste2", "descrição do teste2");
        dicionario1.adicionarPalavra("teste3", "descrição do teste3");
        dicionario1.adicionarPalavra("teste4", "descrição do teste4");
        dicionario1.exibirPalavras();

        dicionario1.removerPalavra("teste1");
        dicionario1.removerPalavra("teste50");
        dicionario1.exibirPalavras();

    }

}
