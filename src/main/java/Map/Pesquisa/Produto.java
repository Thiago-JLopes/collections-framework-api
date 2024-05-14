package Map.Pesquisa;

public class Produto {
    private String nome;
    private Integer quantidade;
    private Double preco;

    public Produto(String nome, Integer quantidade, Double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco;
    }
}

