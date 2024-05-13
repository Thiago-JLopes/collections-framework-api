package Set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
        System.out.println("Lista de produtos vazia criada com sucesso.");
    }

    public void adicionarProduto(String nome, Integer codigo, Double preco, Integer quantidade) {
        produtoSet.add(new Produto(nome,codigo,preco,quantidade));
        System.out.println("Produto adicionado com sucesso.");
    }

    public void exibirProdutosPorNome() {
        if(produtoSet.isEmpty()) {
            throw new RuntimeException("O conjunto está vazio.");
        } else {
            Set<Produto> ordenadoPorNome = new TreeSet<>(produtoSet);
            System.out.println(ordenadoPorNome);
        }
    }

    public void exibirProdutosPorPreco(){
        if(produtoSet.isEmpty()) {
            throw new RuntimeException("O conjunto está vazio.");
        } else {
            Set<Produto> produtosOrdenadosPorPreco = new TreeSet<>(new OrdenarPorPreco());
            System.out.println(produtosOrdenadosPorPreco);
        }
    }

    public static void main(String[] args) {
        CadastroProdutos produtos = new CadastroProdutos();
        produtos.adicionarProduto("Caderno", 1234, 12.55, 8);
        produtos.adicionarProduto("Borracha", 1834, 2.50, 18);
        produtos.adicionarProduto("Mochila", 1237, 85.55, 5);
        produtos.adicionarProduto("Estojo", 12348, 8.55, 2);
        produtos.adicionarProduto("Corretivo", 1884, 6.99, 4);
        produtos.adicionarProduto("Lápis de cor", 14634, 22.55, 25);
        produtos.adicionarProduto("Caderno 10 máterias", 1234, 25.99, 29);

        produtos.exibirProdutosPorNome();
        produtos.exibirProdutosPorPreco();
    }
}
