package Set.Pesquisa;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private Boolean statusTarefaConcluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.statusTarefaConcluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getStatusTarefaConcluida() {
        return statusTarefaConcluida;
    }

    public void setStatusTarefaConcluida(Boolean statusTarefaConcluida) {
        this.statusTarefaConcluida = statusTarefaConcluida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(descricao, tarefa.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(descricao);
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", tarefa concluida=" + statusTarefaConcluida +
                '}';
    }
}
