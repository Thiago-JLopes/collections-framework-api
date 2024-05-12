package Set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        if(contatoSet.add(new Contato(nome,numero))) {
            System.out.println("Contato salvo com sucesso");
        } else {
            System.out.println("Contato já existente");
        }
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato>pesquisarPorNome(String nome) {
        Set<Contato> contosEncontrados = new HashSet<>();

        if(contatoSet.isEmpty()) {
            throw new RuntimeException("Nenhum contato salvo");
        } else {
            for(Contato c : contatoSet) {
                if(c.getNome().startsWith(nome)) {
                    contosEncontrados.add(c);
                }
            }
            return contosEncontrados;
        }
    }

    public void atualizarNumeroContato(String nome, int novoNumero) {
        if(contatoSet.isEmpty()) {
            throw new RuntimeException("Lista de contatos está vazia.");
        } else {
            for(Contato c: contatoSet) {
                if(c.getNome().equalsIgnoreCase(nome)) {
                    c.setNumero(novoNumero);
                    System.out.println("Contato atualizado");
                }
            }
        }
    }

    public static void main(String[] args) {
        AgendaContatos contatos = new AgendaContatos();
        contatos.adicionarContato("Tel", 329994963);
        contatos.adicionarContato("Thiago", 111111111);
        contatos.adicionarContato("Thiago2", 111111111);
        contatos.adicionarContato("Thiago2", 111111122);
        contatos.adicionarContato("João", 111111111);

        contatos.exibirContatos();

        contatos.atualizarNumeroContato("Thiago2", 222222222);
        contatos.atualizarNumeroContato("Thiago3", 222222222);

        contatos.exibirContatos();
    }
}
