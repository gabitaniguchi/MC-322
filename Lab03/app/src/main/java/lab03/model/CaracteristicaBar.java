package lab03.model;

public class CaracteristicaBar extends CaracteristicaDeEvento {
    private String nomeDoBar;
    private String inicioHappyHour;
    private String duracaoHappyHour;

    /**
     * Construtor da classe CaracteristicaBar.
     * Este construtor inicializa o objeto CaracteristicaBar com os parâmetros fornecidos.
     * @param nomeDoBar o nome do bar onde o evento ocorre
     * @param inicioHappyHour o horário de início do happy hour
     * @param duracaoHappyHour a duração do happy hour
     */
    public CaracteristicaBar(String nomeDoBar, String inicioHappyHour, String duracaoHappyHour) {
        this.nomeDoBar = nomeDoBar;
        this.inicioHappyHour = inicioHappyHour;
        this.duracaoHappyHour = duracaoHappyHour;
    }

    /**
     * Método que retorna a descrição do evento no bar.
     * Este método retorna uma string detalhando o nome do bar, o horário de início do happy hour e a duração do happy hour.
     * @return uma string contendo a descrição do evento no bar
     */
    @Override
    public String descricao() {
        return ("Evento no bar " + nomeDoBar + ", Happy Hour Início: " + inicioHappyHour + ", Duração: " + duracaoHappyHour);
    }

    /**
     * Retorna o nome do bar onde o evento ocorre.
     * @return o nome do bar
     */
    public String getNomeDoBar() {
        return nomeDoBar;
    }

    /**
     * Define o nome do bar onde o evento ocorre.
     * @param nomeDoBar o nome do bar a ser definido
     */
    public void setNomeDoBar(String nomeDoBar) {
        this.nomeDoBar = nomeDoBar;
    }

    /**
     * Retorna o horário de início do happy hour.
     * @return o horário de início do happy hour
     */
    public String getInicioHappyHour() {
        return inicioHappyHour;
    }

    /**
     * Define o horário de início do happy hour.
     * @param inicioHappyHour o horário de início do happy hour a ser definido
     */
    public void setInicioHappyHour(String inicioHappyHour) {
        this.inicioHappyHour = inicioHappyHour;
    }

    /**
     * Retorna a duração do happy hour.
     * @return a duração do happy hour
     */
    public String getDuracaoHappyHour() {
        return duracaoHappyHour;
    }

    /**
     * Define a duração do happy hour.
     * @param duracaoHappyHour a duração do happy hour a ser definida
     */
    public void setDuracaoHappyHour(String duracaoHappyHour) {
        this.duracaoHappyHour = duracaoHappyHour;
    }
}
