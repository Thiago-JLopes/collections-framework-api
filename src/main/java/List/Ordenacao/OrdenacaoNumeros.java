package List.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numerosInteirosList;

    public OrdenacaoNumeros() {
        this.numerosInteirosList = new ArrayList<>();
    }

    public void adicionarNumero(int n) {
        numerosInteirosList.add(n);
        System.out.println("Número " + n + " adicionado a lista.");
    }

    public List<Integer> OrdenarAscendente() {
        List<Integer> numerosOrdenadosAscendente = new ArrayList<>(this.numerosInteirosList);

        if(numerosInteirosList.isEmpty()) {
            throw new RuntimeException("Lista vazia.");
        } else {
            Collections.sort(numerosOrdenadosAscendente);
            return numerosOrdenadosAscendente;
        }
    }

    public List<Integer> OrdenarDescendentes() {
        List<Integer> numerosOrdenadosDescendentes = new ArrayList<>(this.numerosInteirosList);

        if(numerosInteirosList.isEmpty()) {
            throw new RuntimeException("Lista vazia.");
        } else {
            numerosOrdenadosDescendentes.sort(Collections.reverseOrder());
            return numerosOrdenadosDescendentes;
        }
    }

    public void exibirNumeros() {
        if(this.numerosInteirosList.isEmpty()) {
            throw new RuntimeException("A lista está vazia.");
        } else {
            System.out.println(this.numerosInteirosList);
        }
    }

    @Override
    public String toString() {
        return "numerosInteirosList=" + numerosInteirosList;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();
        numeros.adicionarNumero(3);
        numeros.adicionarNumero(9);
        numeros.adicionarNumero(57);
        numeros.adicionarNumero(155);
        numeros.adicionarNumero(58);
        numeros.adicionarNumero(15);

        numeros.exibirNumeros();
        System.out.println(numeros.OrdenarAscendente());
        System.out.println(numeros.OrdenarDescendentes());
    }
}
