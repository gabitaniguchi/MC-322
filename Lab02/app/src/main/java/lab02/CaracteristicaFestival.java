package lab02;

import java.util.List;

public class CaracteristicaFestival extends CaracteristicaDeEvento {
    private List<String> lineup;
    private int duracao;

    public CaracteristicaFestival(List<String> lineup, int duracao) {
        this.lineup = lineup;
        this.duracao = duracao;
    }

    @Override
    public String descricao() {
        return "Festival com Lineup: " + lineup + ", e Duração: " + duracao;
    }
}
