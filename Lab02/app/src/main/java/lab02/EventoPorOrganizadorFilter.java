package lab02;

import java.util.ArrayList;
import java.util.List;

public class EventoPorOrganizadorFilter implements Filter<Evento> {

    private Organizadora organizadora;
    
    /**
     * Construtor da classe EventoPorOrganizadorFilter
     * @param organizadora o nome a ser filtrado
     */
    public EventoPorOrganizadorFilter(Organizadora organizadora){
        this.organizadora = organizadora;
    }

    @Override
    public List<Evento> meetCriteria(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();

        for(Evento evento: eventos){
            if(evento.getOrganizadora().equals(organizadora)){
                eventosFiltrados.add(evento);
            }
        }

        return eventosFiltrados;
    }
}
