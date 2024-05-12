package Set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConjuntoPalavrasUnicas that)) return false;
        return Objects.equals(palavrasUnicas, that.palavrasUnicas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(palavrasUnicas);
    }

    @Override
    public String toString() {
        return "palavrasUnicas=" + palavrasUnicas;
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra) {

        if(palavrasUnicas.isEmpty()) {
            throw new RuntimeException("Conjunto vazio.");
        } else {
            if(palavrasUnicas.contains(palavra)){
                palavrasUnicas.remove(palavra);
                System.out.println("Palavra " + palavra + " removida com sucesso.");
            } else {
                System.out.println("A palavra " + palavra + " não está contida no conjunto.");
            }
        }
    }

    public void verificarPalavra(String palavra) {
        if(palavrasUnicas.contains(palavra)) {
            System.out.println("A palavra " + palavra + " está contida no conjunto");
        } else  {
            System.out.println("A palavra " + palavra + " não está contida no conjunto");
        }
    }

    public void exibirPalavrasUnicas() {
        System.out.println(palavrasUnicas);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas palavras = new ConjuntoPalavrasUnicas();
        palavras.adicionarPalavra("teste");
        palavras.adicionarPalavra("teste1");
        palavras.adicionarPalavra("teste2");
        palavras.exibirPalavrasUnicas();
        palavras.removerPalavra("teste");
        palavras.exibirPalavrasUnicas();
    }
}
