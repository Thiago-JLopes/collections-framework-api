package Set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto>{
    private String nome;
    private Integer codigo;
    private Double preco;
    private Integer quntidade;

    public Produto(String nome, Integer codigo, Double preco, Integer quntidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quntidade = quntidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuntidade() {
        return quntidade;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", preco=" + preco +
                ", quntidade=" + quntidade;
    }

    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getNome());
    }
}

class OrdenarPorPreco implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
