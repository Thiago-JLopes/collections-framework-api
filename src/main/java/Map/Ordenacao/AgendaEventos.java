package Map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class AgendaEventos {
    private Map<LocalDate,Evento> agendaeventos;

    public AgendaEventos() {
        this.agendaeventos = new HashMap<>();
    }

    void adicionarEvento(LocalDate data, String nomeEvento, String nomeAtracao) {
        agendaeventos.put(data, new Evento(nomeEvento,nomeAtracao));
        System.out.println("Evento adicionado com sucesso.");
    }

    void exibirAgenda() {
        System.out.println(agendaeventos);
    }

    void obterProximoEvento() {
        Evento proximoEvento = null;
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;

        if(agendaeventos.isEmpty()) {
            throw new RuntimeException("agenda vazia.");
        } else {

            for(Map.Entry<LocalDate,Evento> entry : agendaeventos.entrySet()) {
                LocalDate dataEvento = entry.getKey();
                if(dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
                    proximaData = dataEvento;
                    proximoEvento = entry.getValue();
                    break;
                }
            }

            if(proximoEvento != null) {
                System.out.println("O proximo evento é " + proximoEvento);
                System.out.println("Vai acontecer em: " + proximaData);
            }
            else {
                System.out.println("Não tem mais eventos.");
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos eventos = new AgendaEventos();
        eventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 16), "Show", "Anitta");
        eventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 17), "Show", "Tyla");

        eventos.exibirAgenda();
        eventos.obterProximoEvento();
    }
}
