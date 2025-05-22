package lab02.model;

import java.util.ArrayList;
import java.util.List;

public class EventoPorDataFilter implements Filter<Evento> {

    private String data;
    
    /**
     * Construtor da classe EventoPorDataFilter
     * @param data o nome a ser filtrado
     */
    public EventoPorDataFilter(String data){
        this.data = data;
    }

    /**
     * Filtra os eventos pela data
     * @return lista com todos os eventos com a data em questão
     */
    @Override
    public List<Evento> meetCriteria(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();

        for(Evento evento: eventos){
            if(evento.getData().equals(data)){
                eventosFiltrados.add(evento);
            }
        }

        return eventosFiltrados;
    }
}
