package lab02;

public class CaracteristicaMusicaAoVivo extends CaracteristicaDeEvento {

    private String nomeDoArtista;
    private String generoMusical;

    /**
     * Construtor da classe CaracteristicaMusicaAoVivo.
     * Este construtor inicializa o objeto com o nome do artista e o gênero musical.
     * @param nomeArtista o nome do artista que irá se apresentar
     * @param generoMusical o gênero musical da apresentação
     */
    public CaracteristicaMusicaAoVivo(String nomeArtista, String generoMusical) {
        this.nomeDoArtista = nomeArtista;
        this.generoMusical = generoMusical;
    }

    /**
     * Método que retorna a descrição do evento de música ao vivo.
     * Este método retorna uma string com o nome do artista e o gênero musical.
     * @return uma string contendo a descrição do evento de música ao vivo
     */
    @Override
    public String descricao() {
        return("Musica ao vivo com " + nomeDoArtista + " (" + generoMusical + ")");
    }

    /**
     * Retorna o nome do artista que se apresenta no evento.
     * @return o nome do artista
     */
    public String getNomeDoArtista() {
        return nomeDoArtista;
    }

    /**
     * Define o nome do artista para o evento de música ao vivo.
     * @param nomeDoArtista o nome do artista que irá se apresentar
     */
    public void setNomeDoArtista(String nomeDoArtista) {
        this.nomeDoArtista = nomeDoArtista;
    }

    /**
     * Retorna o gênero musical da apresentação ao vivo.
     * @return o gênero musical
     */
    public String getGeneroMusical() {
        return generoMusical;
    }

    /**
     * Define o gênero musical para o evento de música ao vivo.
     * 
     * @param generoMusical o gênero musical do evento
     */
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
}