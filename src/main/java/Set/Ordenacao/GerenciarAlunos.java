package Set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciarAlunos {
    private Set<Aluno> alunoSet;

    public GerenciarAlunos() {
        this.alunoSet = new HashSet<>();
        System.out.println("Conjunto de alunos vazio criado com sucesso.");
    }

    void adicionarAluno(String nome, long matricula, double media) {
        alunoSet.add(new Aluno(nome,matricula,media));
        System.out.println("Aluno adicionado com sucesso.");
    }

    void removerAluno(long matricula) {
        if(alunoSet.isEmpty()) {
            throw new RuntimeException("O conjunto de alunos esta vazio.");
        } else {
            for(Aluno a : alunoSet) {
                if(a.getMatricula() == matricula) {
                    alunoSet.remove(a);
                    System.out.println("Aluno removido com sucesso.");
                    break;
                }
            }
        }
    }

    void exibirAlunosPorNome() {
        if(alunoSet.isEmpty()) {
            throw new RuntimeException("O conjunto de alunos esta vazio.");
        } else {
            Set<Aluno> ordenadosPorNome = new TreeSet<>(alunoSet);
            System.out.println("Alunos ordenados por nome " + ordenadosPorNome);
        }
    }

    void exibirAlunosPorNota() {
        if(alunoSet.isEmpty()) {
            throw new RuntimeException("Conjunto de alunos está vazio.");
        } else {
            Set<Aluno> alunos = new TreeSet<>(new AlunosPorNota());
            alunos.addAll(alunoSet);
            System.out.println(alunos);
        }
    }

    public static void main(String[] args) {
        GerenciarAlunos alunos = new GerenciarAlunos();
        alunos.adicionarAluno("Amanda", 154855861, 5.8);
        alunos.adicionarAluno("Thiago", 202076014, 9.8);
        alunos.adicionarAluno("Bianca", 202077814, 8.8);
        alunos.adicionarAluno("Aaron", 202075076, 9.9);

        alunos.exibirAlunosPorNome();
        alunos.exibirAlunosPorNota();
    }


}
