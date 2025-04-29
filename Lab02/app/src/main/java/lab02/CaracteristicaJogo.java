package lab02;

import java.util.List;

public class CaracteristicaJogo extends CaracteristicaDeEvento {
    private List<String> times;

    /**
     * Construtor da classe CaracteristicaJogo.
     * Este construtor inicializa o objeto CaracteristicaJogo com a lista de times.
     * @param times a lista de times que irão jogar no evento
     */
    public CaracteristicaJogo(List<String> times) {
        this.times = times;
    }

    /**
     * Método que retorna a descrição do evento de jogo.
     * Este método retorna uma string com os times que irão participar do jogo.
     * @return uma string contendo os times do jogo
     */
    @Override
    public String descricao() {
        return "Jogo com times: " + times;
    }

    /**
     * Retorna a lista de times do jogo.
     * @return a lista de times
     */
    public List<String> getTimes() {
        return times;
    }

    /**
     * Define a lista de times que irão jogar no evento.
     * @param times a lista de times a serem definidos para o evento de jogo
     */
    public void setTimes(List<String> times) {
        this.times = times;
    }
}
