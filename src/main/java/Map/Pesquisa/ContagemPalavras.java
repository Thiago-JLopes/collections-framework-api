package Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<>();
    }

    void adicionarPalavra(String palavra, Integer contagem) {
        contagemMap.put(palavra, contagem);
    }

    void removerPalavra(String palavra) {
        if(contagemMap.isEmpty()) {
            throw new RuntimeException("conjunto vazio");
        } else {
            if(contagemMap.containsKey(palavra)){
                contagemMap.remove(palavra);
            } else {
                System.out.println("A palavra não está contida no conjunto.");
            }
        }
    }

    void exibirContagemPalavras() {
        int contagemTotal = 0;
        for(int i : contagemMap.values()) {
            contagemTotal += i;
        }
        System.out.println("A contagem total de palavras é " + contagemTotal);
    }

    void encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        int maiorContagem = 0;
        if(contagemMap.isEmpty()) {
            throw new RuntimeException("conjunto vazio.");
        } else {
            for(Map.Entry<String,Integer> entry : contagemMap.entrySet()) {
                if(entry.getValue() > maiorContagem) {
                    maiorContagem = entry.getValue();
                    palavraMaisFrequente = entry.getKey();
                }
            }
            System.out.println("A palavra mais frequente é: " + palavraMaisFrequente);
        }
    }


    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        contagemPalavras.adicionarPalavra("Java", 55);
        contagemPalavras.exibirContagemPalavras();
        contagemPalavras.adicionarPalavra("C++", 20);
        contagemPalavras.adicionarPalavra("Ruby", 12);

        contagemPalavras.exibirContagemPalavras();
        contagemPalavras.removerPalavra("Ruby");
        contagemPalavras.adicionarPalavra("Python", 56);

        contagemPalavras.encontrarPalavraMaisFrequente();
    }
}
