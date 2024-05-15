package Map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String,Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    void adcionarLivro(String link, String titulo, String autor, Double preco) {
        livroMap.put(link, new Livro(titulo,autor,preco));
        System.out.println("Livro adicionado com sucesso.");
    }

    void removerLivro(String titulo) {
        if(livroMap.isEmpty()) {
            System.out.println("Map de livros está vazio.");
        } else {
            for(Map.Entry<String,Livro> entry : livroMap.entrySet()) {
                if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    livroMap.remove(entry.getKey());
                    System.out.println("Livro removido com sucesso.");
                    break;
                } else {
                    System.out.println("Livro não encontrado.");
                }
            }
        }
    }

    void exibirLivrosPorPreco() {
        if(livroMap.isEmpty()){
            throw new RuntimeException("Não há livros para exibir.");
        } else {

            List<Map.Entry<String,Livro>> livrosPorPreco = new ArrayList<>(livroMap.entrySet());
            Collections.sort(livrosPorPreco, new comparadorPorPreco());

            System.out.println(livrosPorPreco);
        }
    }

    void exibirLivrosPorAutor(String autor) {
        if(livroMap.isEmpty()) {
            throw new RuntimeException("Não existem livros para serem exibidos.");
        } else {
            List<Livro> livrosPorAutor = new ArrayList<>();
            for (Map.Entry<String,Livro> entry : livroMap.entrySet()) {
                if(entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(entry.getValue());
                }
            }
            System.out.println(livrosPorAutor);
        }
    }

    void obterLivroMaisCaro() {
        Livro livroMaisCaro = null;
        Double maiorValor = Double.MIN_VALUE;
        if(!livroMap.isEmpty()) {
            for(Map.Entry<String,Livro> entry : livroMap.entrySet()) {
                if(entry.getValue().getPreco() > maiorValor) {
                    maiorValor = entry.getValue().getPreco();
                    livroMaisCaro = entry.getValue();
                }
            }
            System.out.println("O livro mais caro: " + livroMaisCaro);
        } else  {
            throw new RuntimeException("Não há livros.");
        }
    }

    void obterLivroMaisBarato() {
        Livro livroMaisBarato = null;
        Double menorValor = Double.MAX_VALUE;
        if(!livroMap.isEmpty()) {
            for(Map.Entry<String,Livro> entry : livroMap.entrySet()) {
                if(entry.getValue().getPreco() < menorValor) {
                    menorValor = entry.getValue().getPreco();
                    livroMaisBarato = entry.getValue();
                }
            }
            System.out.println("O livro mais barato: " + livroMaisBarato);
        } else  {
            throw new RuntimeException("Não há livros.");
        }
    }
    public static void main(String[] args) {
        LivrariaOnline livros = new LivrariaOnline();
        livros.adcionarLivro("123548967245", "java", "Thiago", 105.99);
        livros.adcionarLivro("123548975245", "java2", "Thiago", 115.99);
        livros.adcionarLivro("127548975245", "java3", "Thiago", 99.99);
        livros.adcionarLivro("127548975248", "java para iniciantes", "Thiago José", 99.99);
        livros.adcionarLivro("127548975249", "C++ para iniciantes", "Thiago José", 99.99);
        livros.exibirLivrosPorPreco();
        livros.removerLivro("java");
        livros.exibirLivrosPorPreco();
        livros.exibirLivrosPorAutor("Thiago");
        livros.obterLivroMaisBarato();
        livros.obterLivroMaisCaro();
    }
}
