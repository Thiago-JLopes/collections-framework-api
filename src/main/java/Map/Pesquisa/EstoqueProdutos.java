package Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long,Produto>produtoMap;

    public EstoqueProdutos() {
        this.produtoMap = new HashMap<>();
    }

    void adicionarProduto(Long codigo, String nome, Integer quantidade, Double preco) {
        if(produtoMap.containsKey(codigo)) {
            throw new RuntimeException("Este código já existe.");
        } else {
            produtoMap.put(codigo, new Produto(nome,quantidade,preco));
            System.out.println("Produto adicionado com sucesso.");
        }
    }

    void exibirProdutos() {
        System.out.println(produtoMap);
    }

    Double calcularValorTotalEstoque() {
        double valorTotal = 0.0;
        if(produtoMap.isEmpty()) {
            throw new RuntimeException("Conjunto vazio.");
        } else {
            for (Produto p : produtoMap.values()) {
                valorTotal += (p.getPreco() * p.getQuantidade());
            }
        }
        return valorTotal;
    }

    Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        Double valorMaisAlto = Double.MIN_VALUE;

        if(produtoMap.isEmpty()) {
            throw new RuntimeException("Conjunto vazio.");
        } {
            for(Produto p : produtoMap.values()) {
                if(p.getPreco() > valorMaisAlto) {
                    produtoMaisCaro = p;
                    valorMaisAlto = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }

    Produto obterProdutoMaisBarato() {
        Produto produtoMaisBararato = null;
        Double valorMaisAlto = Double.MAX_VALUE;

        if(produtoMap.isEmpty()) {
            throw new RuntimeException("Conjunto vazio.");
        } {
            for(Produto p : produtoMap.values()) {
                if(p.getPreco() < valorMaisAlto) {
                    produtoMaisBararato = p;
                    valorMaisAlto = p.getPreco();
                }
            }
        }
        return produtoMaisBararato;
    }

    Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorTotalNoEstoque = null;
        double maiorValorProduto = 0d;

        if(!produtoMap.isEmpty()) {
            for(Map.Entry<Long,Produto> entry : produtoMap.entrySet()) {
                double valor = (entry.getValue().getPreco() * entry.getValue().getQuantidade());
                if(valor > maiorValorProduto) {
                    maiorValorProduto = valor;
                    produtoMaiorQuantidadeValorTotalNoEstoque = entry.getValue();
                }
            }
        } else {
            throw new RuntimeException("O conjunto esta vazio.");
        }
        return produtoMaiorQuantidadeValorTotalNoEstoque;
    }


    public static void main(String[] args) {
        EstoqueProdutos produtos = new EstoqueProdutos();
        produtos.adicionarProduto(5489248L, "caneta", 15, 2.50);
        produtos.exibirProdutos();
        produtos.adicionarProduto(1548L, "caderno", 78, 15.99);
        System.out.println(produtos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
        System.out.println(produtos.obterProdutoMaisBarato());
        System.out.println(produtos.obterProdutoMaisCaro());
        System.out.println(produtos.calcularValorTotalEstoque());
    }
}
