package lab02;

import java.util.ArrayList;
import java.util.List;

public class EventoPorLocalFilter implements Filter<Evento> {

    private Local local;
    
    /**
     * Construtor da classe EventoPorLocalFilter
     * @param local o nome a ser filtrado
     */
    public EventoPorLocalFilter(Local local){
        this.local = local;
    }

    /**
     * Filtra os eventos pelo local
     * @return lista com todos os eventos com o local em questão
     */
    @Override
    public List<Evento> meetCriteria(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();

        for(Evento evento: eventos){
            if(evento.getLocal().equals(local)){
                eventosFiltrados.add(evento);
            }
        }

        return eventosFiltrados;
    }
}
