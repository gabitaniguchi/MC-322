package lab02;

public class CaracteristicaShow extends CaracteristicaDeEvento {
    private String artista;

    /**
     * Construtor da classe CaracteristicaShow.
     * Este construtor inicializa o objeto com o nome do artista do show.
     * @param artista o nome do artista que realizará o show
     */
    public CaracteristicaShow(String artista) {
        this.artista = artista;
    }

    /**
     * Retorna o nome do artista que se apresenta no evento de show.
     * @return o nome do artista do show
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Define o nome do artista para o evento de show.
     * @param artista o nome do artista que realizará o show
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * Método que retorna a descrição do evento de show.
     * Este método retorna uma string com o nome do artista do show.
     * @return uma string contendo a descrição do show
     */
    @Override
    public String descricao() {
        return "Show do artista: " + artista;
    }
}
