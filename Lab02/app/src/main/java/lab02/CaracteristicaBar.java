package lab02;

public class CaracteristicaBar extends CaracteristicaDeEvento {
    private String nomeDoBar;
    private String inicioHappyHour;
    private String duracaoHappyHour;

    public CaracteristicaBar(String nomeDoBar, String inicioHappyHour, String duracaoHappyHour) {
        this.nomeDoBar = nomeDoBar;
        this.inicioHappyHour = inicioHappyHour;
        this.duracaoHappyHour = duracaoHappyHour;
    }

    @Override
    public String descricao() {
        return ("Evento no bar " + nomeDoBar + ", Happy Hour Início: " + inicioHappyHour + ", Duração: " + duracaoHappyHour);
    }
}
