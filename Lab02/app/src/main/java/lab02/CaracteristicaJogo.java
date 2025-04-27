package lab02;

import java.util.List;

public class CaracteristicaJogo extends CaracteristicaDeEvento {
    private List<String> times;

    public CaracteristicaJogo(List<String> times) {
        this.times = times;
    }

    @Override
    public String descricao() {
        return "Esporte com times: " + times;
    }
}