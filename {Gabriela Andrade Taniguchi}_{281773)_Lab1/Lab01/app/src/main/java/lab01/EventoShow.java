package lab01;

/**
 * Contém a estrutura de implementação de um Evento Show.
 * 
 * @author Gabriela Taniguchi - 281773
 */

public class EventoShow extends Evento {
    private int duracao;
    private String generoMusical;
    private String artista;
    private String data;

    /**
     * Construtor da classe EventoShow
     * @param duracao a duração do EventoShow
     * @param generoMusical o gênero musical do EventoShow
     * @param artista o artista do EventoShow
     * @param data a data do EventoShow
     */
    public EventoShow(int duracao, String generoMusical, String artista, String data, String nome, Local local, double precoIngresso){
        super(nome, local, precoIngresso);
        this.duracao = duracao;
        this.generoMusical = generoMusical;
        this.artista = artista;
        this.data = data;
    }

     /**
     * Retorna a duração do EventoShow
     * @return a duração do EventoShow
     */
    public int getDuracao(){
        return duracao;
    }

    /**
     * Altera a duração do EventoShow para 'duracao' 
     * @param duracao o nova duração do EventoShow
     */
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    /**
     * Retorna o artista do EventoShow
     * @return o artista do EventoShow
     */
    public String getArtista(){
        return artista;
    }

    /**
     * Altera o artista do EventoShow para 'artista' 
     * @param artista o novo artista do EventoShow
     */
    public void setArtista(String artista){
        this.artista = artista;
    }

    /**
     * Retorna o genero musical do EventoShow
     * @return o genero musical do EventoShow
     */
    public String getGeneroMusical(){
        return generoMusical;
    }

    /**
     * Altera o genero musical do EventoShow para 'genero musical' 
     * @param generoMusical o novo genero musical do EventoShow
     */
    public void setGeneroMusical(String generoMusical){
        this.generoMusical = generoMusical;
    }

    /**
     * Retorna a data do EventoShow
     * @return a data do EventoShow
     */
    public String getData(){
        return data;
    }

    /**
     * Altera a data do EventoShow para 'data' 
     * @param data a nova data do EventoShow
     */
    public void setData(String data){
        this.data = data;
    }

    /**
     * Imprime os detalhes do EventoShow
     * @param duracao a duração do EventoShow
     * @param generoMusical o gênero musical do EventoShow
     * @param artista o artista do EventoShow
     * @param data a data do EventoShow
     */
    public void exibirDetalhes(){
        
        System.out.println("Evento Show : " + this.getNome());
        System.out.println("Duração: " + duracao + " min");
        System.out.println("Gênero musical: " + generoMusical);
        System.out.println("Artista: " + artista);
        System.out.println("Data: " + data);
        System.out.println();
    }
}
