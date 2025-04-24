package lab02;

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
