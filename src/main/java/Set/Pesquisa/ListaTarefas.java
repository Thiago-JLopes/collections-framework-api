package Set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
        System.out.println("Lista de tarfas vazias criada com sucesso.");
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada com sucesso");
    }

    public void removerTarefa(String descricao) {
        if(tarefaSet.isEmpty()) {
            throw new RuntimeException("Lista de tarefas está vazia.");
        } else {
            for(Tarefa t : tarefaSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaSet.remove(t);
                    System.out.println("Tarefa Removida com sucesso.");
                    break;
                }
            }
        }
    }

    public void exibirTarefas() {
        System.out.println(tarefaSet);
    }

    public void contarTarefas() {
        System.out.println("A quantidade de tarefas: " + tarefaSet.size());
    }

    public Set<Tarefa>obterTarefasConcluidas() {
        Set<Tarefa>concluidas = new HashSet<>();

        for(Tarefa t : tarefaSet) {
            if(t.getStatusTarefaConcluida()) {
                concluidas.add(t);
            }
        }

        return concluidas;
    }

    public Set<Tarefa>obterTarefasPendentes() {
        Set<Tarefa>naoConcluidas = new HashSet<>();

        for(Tarefa t : tarefaSet) {
            if(!t.getStatusTarefaConcluida()) {
                naoConcluidas.add(t);
            }
        }

        return naoConcluidas;
    }

    public void marcarTarefaConcluida(String descricao) {
        if(tarefaSet.isEmpty()) {
            throw new RuntimeException("Lista de tarefas está vazia.");
        } else {
            for(Tarefa t : tarefaSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setStatusTarefaConcluida(true);
                    System.out.println("Tarefa marcada como concluida.");
                }
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        if(tarefaSet.isEmpty()) {
            throw new RuntimeException("Lista de tarefas está vazia.");
        } else {
            for(Tarefa t : tarefaSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setStatusTarefaConcluida(false);
                    System.out.println("Tarefa marcada como pendente.");
                }
            }
        }
    }

    public void limparListaTarefas() {
        Set<Tarefa> tarefasRemover = new HashSet<>(tarefaSet);
        tarefaSet.removeAll(tarefasRemover);

        System.out.println("Lista de tarefas removida com sucesso.");
    }

    public static void main(String[] args) {
        ListaTarefas tarefas = new ListaTarefas();
        tarefas.adicionarTarefa("Passear com o cachorro.");
        tarefas.adicionarTarefa("Ir ao supermercado.");
        tarefas.adicionarTarefa("Estudar cálculo.");
        tarefas.adicionarTarefa("Ir para academia.");

        tarefas.exibirTarefas();
        tarefas.contarTarefas();
        tarefas.marcarTarefaConcluida("Ir ao supermercado.");
        System.out.println(tarefas.obterTarefasConcluidas());
        System.out.println(tarefas.obterTarefasPendentes());
        tarefas.marcarTarefaPendente("Ir ao supermercado.");

        tarefas.limparListaTarefas();
        tarefas.contarTarefas();

    }
}
