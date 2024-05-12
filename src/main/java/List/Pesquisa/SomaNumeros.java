package List.Pesquisa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SomaNumeros {
    private List<Integer> numerosInteiros;

    public SomaNumeros() {
        this.numerosInteiros = new ArrayList<>();
    }

    public void adicionarNumeros(Integer numero) {
        numerosInteiros.add(numero);
    }

    public Integer calcularSoma() {
        AtomicReference<Integer> soma = new AtomicReference<>(0);
        numerosInteiros.forEach(integer -> soma.updateAndGet(v -> v + integer));
        return soma.get();
    }

    public Integer encontrarMaiorNumero() {
        Integer maior = numerosInteiros.get(0);
        for(Integer n : numerosInteiros) {
            if(n > maior) {
                maior = n;
            }
        }
        return maior;
    }

    public Integer encontrarMenorNumero() {
        Integer menor = numerosInteiros.get(0);
        for(Integer n : numerosInteiros) {
            if(n < menor) {
                menor = n;
            }
        }
        return menor;
    }

    public void exibirNumeros() {
        System.out.println(numerosInteiros);
    }


    @Override
    public String toString() {
        return "numerosInteiros=" + numerosInteiros;
    }

    public static void main(String[] args) {
        SomaNumeros numeros = new SomaNumeros();

        numeros.adicionarNumeros(10);
        numeros.adicionarNumeros(2);
        numeros.adicionarNumeros(35);
        numeros.adicionarNumeros(-19);
        numeros.adicionarNumeros(56);

        System.out.println(numeros.calcularSoma());
        System.out.println("Maior número: " + numeros.encontrarMaiorNumero());
        System.out.println("Menor número: " + numeros.encontrarMenorNumero());
        numeros.exibirNumeros();
    }
}
