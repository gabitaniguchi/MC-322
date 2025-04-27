package lab02;

public class CaracteristicaShow extends CaracteristicaDeEvento {
    private String artista;

    public CaracteristicaShow(String artista) {
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String descricao() {
        return "Show do artista: " + artista;
    }
}
