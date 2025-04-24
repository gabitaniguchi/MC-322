package lab02;

import java.util.List;

public interface Filter<T> {

    List<T> meetCriteria(List<T> elementos);
    
}
