package List.OperacoesBasicas;

//SEM TRATAMENTO DE EXCEÇÃO
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {
    private List<Item> myList;

    public CarrinhoDeCompra() {
        this.myList = new ArrayList<>();
    }

    public List<Item> getMyList() {
        return myList;
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        myList.add(new Item(nome,preco,quantidade));
    }

    public void removerItem(String nome) {
        List<Item> auxList = new ArrayList<>();

        if(!myList.isEmpty()) {
            for(Item i : myList) {
                if(i.getNome().equalsIgnoreCase(nome)) {
                    auxList.add(i);
                }
            }

            myList.removeAll(auxList);
        } else {
            System.out.println("O carrinho esta vazio.");
        }
    }

    public void calcularValorTotal() {
        double valorTotal = 0.0;

        if(!myList.isEmpty()) {
            for(Item i : myList) {
                valorTotal += (i.getQuantidade() * i.getPreco());
            }
        }
        System.out.println("o valor total: R$" + valorTotal);
    }

    public void exibirItens() {
        System.out.println(myList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
        carrinho.adicionarItem("Caneta",2.50,5);
        carrinho.adicionarItem("Caderno",15.50,2);
        carrinho.adicionarItem("Caderno",15.50,2);

        carrinho.exibirItens();
        carrinho.calcularValorTotal();
        carrinho.removerItem("Caderno");

        carrinho.exibirItens();
    }
}

