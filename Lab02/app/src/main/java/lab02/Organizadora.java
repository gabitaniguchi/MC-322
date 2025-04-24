package lab02;

import java.util.List;

public class Organizadora {

    private String nome;
    private int cnpj;
    private String endereco;

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, int cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    /**
     * Método criarEvento para o Evento Festival
     * @param nome o nome do Evento
     * @param local o local do Evento
     * @param precoIngresso o preço do Ingresso do Evento]
     * @param organizadora a organizadora do Evento
     * @param data a data do Festival
     * @param lineup a lista com os nomes dos artistas do Festival
     * @param duracao a duração do Festival
     */
    public EventoFestival criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, List<String> lineup, int duracao){
        return new EventoFestival(nome, local, precoIngresso, organizadora, data, lineup, duracao);
    }

    /**
     * Método criarEvento para o Evento Jogo
     * @param nome o nome do Evento
     * @param local o local do Evento
     * @param precoIngresso o preço do Ingresso do Evento
     * @param organizadora a organizadora do Evento
     * @param data a data do Evento
     * @param times lista com os nomes dos times que se enfrentam no Evento
     */
    public EventoJogo criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, List<String> times){
        return new EventoJogo(nome, local, precoIngresso, organizadora, data, times);
    }

    /**
    * Método criarEvento para o Evento Jogo
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param artista o artista do Evento
    * @param organizadora a organizadora do Evento
    */
    public EventoShow criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, String artista){
        return new EventoShow(nome, local, precoIngresso, organizadora, data, artista);
    }

    
    
}
