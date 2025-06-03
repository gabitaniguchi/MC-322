package lab03.model;

import java.util.List;

public interface Filter<T> {

    List<T> meetCriteria(List<T> elementos);
    
}
