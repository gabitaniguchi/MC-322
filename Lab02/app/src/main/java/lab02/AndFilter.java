package lab02;

import java.util.List;

public class AndFilter implements Filter<Evento> {

    private Filter<Evento> filtro1;
    private Filter<Evento> filtro2;

    public AndFilter(Filter<Evento> filtro1, Filter<Evento> filtro2){
        this.filtro1 = filtro1;
        this.filtro2 = filtro2;
    }

    /*
     * Método para retornar uma lista de eventos com base em dois critérios/filtros
     */

    @Override
    public List<Evento> meetCriteria(List<Evento> eventos){
        List<Evento> primeiroFiltro = filtro1.meetCriteria(eventos);
        return filtro2.meetCriteria(primeiroFiltro);
    }
    
}