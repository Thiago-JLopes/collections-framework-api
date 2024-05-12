package Set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
        System.out.println("Conjunto de convidados vazios criado.");
    }

    public void adicionarConvidado(String nome, Integer codigoConvite) {
        if(convidadoSet.add(new Convidado(nome, codigoConvite)))
            System.out.println("convidado: " + nome + " adicionado ao conjunto.");
    }

    public void removerCandidatoPorCodigoConvite(Integer codigoConvite) {
        Convidado convidadoRemover = null;

        if(convidadoSet.isEmpty()) {
            throw new RuntimeException("Não há convidados para remover");
        } else {
            for(Convidado c : convidadoSet) {
                if(c.getCodigoConvite().equals(codigoConvite)) {
                    convidadoRemover = c;
                    break;
                }
            }

            convidadoSet.remove(convidadoRemover);
            System.out.println("Convidado " + convidadoRemover.getNome() + " removido com sucesso.");
        }
    }

    public int contarNumeroConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        conjuntoConvidados.adicionarConvidado("Thiago", 12345);
        conjuntoConvidados.adicionarConvidado("Thiago Lopes", 12345);
        conjuntoConvidados.adicionarConvidado("Thiago José", 12347);

        System.out.println(conjuntoConvidados.contarNumeroConvidados());
        conjuntoConvidados.exibirConvidados();
        conjuntoConvidados.removerCandidatoPorCodigoConvite(12345);
    }
}
