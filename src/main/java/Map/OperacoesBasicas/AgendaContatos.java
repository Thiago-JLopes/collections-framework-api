package Map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String,Integer> contatos;

    public AgendaContatos() {
        this.contatos = new HashMap<>();
        System.out.println("Conjunto vazio de contatos foi criado com sucesso.");
    }

    void adicionarContato(String nome, Integer telefone) {
        if(contatos.containsKey(nome)) {
            System.out.println("Este contato jé existe.");
        } else {
            contatos.put(nome, telefone);
            System.out.println("Contato criado com sucesso.");
        }
    }

    void removerContato(String nome) {
        if(contatos.isEmpty()) {
            throw new RuntimeException("Conjunto de contatos está vazio.");
        } else {
            if(contatos.containsKey(nome)) {
                contatos.remove(nome);
                System.out.println("Contato removido.");
            } else {
                System.out.println("Este contato não existe.");
            }
        }
    }

    void exibirContatos() {
        System.out.println(contatos);
    }

    Integer pesquisaPorNome(String nome) {
        if(contatos.isEmpty()) {
            throw new RuntimeException("Contatos vazios.");
        } else {
            if(contatos.containsKey(nome)) {
                return contatos.get(nome);
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "AgendaContatos "+ contatos;
    }

    public static void main(String[] args) {
        AgendaContatos contatos1 = new AgendaContatos();
        contatos1.adicionarContato("Thiago", 329999111);
        System.out.println(contatos1.pesquisaPorNome("Thiago"));
        contatos1.adicionarContato("Maria", 329884911);
        contatos1.exibirContatos();
        contatos1.removerContato("Maria José");
        contatos1.removerContato("Maria");
        contatos1.exibirContatos();
    }
}
