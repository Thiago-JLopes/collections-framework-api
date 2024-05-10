package List.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> meusLivros;

    public CatalogoLivros() {
        this.meusLivros = new ArrayList<>();
    }

    public void adicionarLivros(String titulo, String autor, int anoPublicacao) {
        meusLivros.add(new Livro(titulo,autor,anoPublicacao));
    }

    public List<Livro> pesquisaPorAutor(String autor) {
        List<Livro> livrosProcurados = null;
        if(meusLivros.isEmpty()) {
            throw new RuntimeException("A lista está vazia");
        } else {
            for(Livro l : meusLivros) {
                if(l.getAutor().equalsIgnoreCase(autor)) {
                    livrosProcurados.add(l);
                }
            }
        }
        return  livrosProcurados;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosProcurados = null;

        if((anoFinal < anoInicial) || (anoInicial <= 0) || anoFinal <= 0) {
            throw new RuntimeException("Valores incorretos.");
        }

        if (meusLivros.isEmpty()) {
            throw new RuntimeException("A lista está vazia");
        } else {
            for(Livro l : meusLivros) {
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosProcurados.add(l);
                }
            }
        }

        return livrosProcurados;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroProcurado = null;

        if(meusLivros.isEmpty()) {
            throw new RuntimeException("Lista vazia");
        } else {
            for(Livro l : meusLivros) {
                if(l.getTitulo().equalsIgnoreCase(titulo)) {
                    livroProcurado = l;
                    break;
                }
            }
        }
        return livroProcurado;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivros("teste","thiago",2024);
        System.out.println(catalogoLivros.pesquisarPorTitulo("teste"));
    }
}
