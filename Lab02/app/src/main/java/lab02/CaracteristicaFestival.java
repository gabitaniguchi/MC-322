package lab02;

import java.util.List;

public class CaracteristicaFestival extends CaracteristicaDeEvento {
    private List<String> lineup;
    private String duracao;

    /**
     * Construtor da classe CaracteristicaFestival.
     * Este construtor inicializa o objeto CaracteristicaFestival com os parâmetros fornecidos.
     * @param lineup a lista de artistas ou bandas que irão se apresentar no festival
     * @param duracao a duração do festival
     */
    public CaracteristicaFestival(List<String> lineup, String duracao) {
        this.lineup = lineup;
        this.duracao = duracao;
    }

    /**
     * Método que retorna a descrição do evento do festival.
     * Este método retorna uma string detalhando o lineup e a duração do festival.
     * @return uma string contendo a descrição do festival
     */
    @Override
    public String descricao() {
        return "Festival com Lineup: " + lineup + ", e Duração: " + duracao;
    }

    /**
     * Retorna o lineup do festival.
     * @return a lista de artistas ou bandas que irão se apresentar no festival
     */
    public List<String> getLineup() {
        return lineup;
    }

    /**
     * Define o lineup do festival.
     * @param lineup a lista de artistas ou bandas a serem definidos para o festival
     */
    public void setLineup(List<String> lineup) {
        this.lineup = lineup;
    }

    /**
     * Retorna a duração do festival.
     * @return a duração do festival
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * Define a duração do festival.
     * @param duracao a duração do festival a ser definida
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
