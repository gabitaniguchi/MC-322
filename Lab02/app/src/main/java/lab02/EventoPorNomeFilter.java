package lab02;

import java.util.ArrayList;
import java.util.List;

public class EventoPorNomeFilter implements Filter<Evento> {

    private String nome;
    
    /**
     * Construtor da classe EventoPorNomeFilter
     * @param nome o nome a ser filtrado
     */
    public EventoPorNomeFilter(String nome){
        this.nome = nome;
    }

    @Override
    public List<Evento> meetCriteria(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();

        for(Evento evento: eventos){
            if(evento.getNome().equals(nome)){
                eventosFiltrados.add(evento);
            }
        }

        return eventosFiltrados;
    }
}
