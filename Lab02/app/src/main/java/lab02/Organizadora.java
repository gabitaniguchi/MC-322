package lab02;

import java.util.ArrayList;
import java.util.List;

public class Organizadora {

    private String nome;
    private int cnpj;
    private String endereco;
    private List<Evento> eventos;

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
        this.eventos = new ArrayList<>();
    }

    /**
     * Define o nome da organizadora
     * @param nome o novo nome da organizadora
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome da organizadora
     * @return o nome da organizadora
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o CNPJ da organizadora
     * @param cnpj o novo CNPJ da organizadora
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Retorna o CNPJ da organizadora
     * @return o CNPJ da organizadora
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * Define o endereço da organizadora
     * @param endereco o novo endereço da organizadora
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o endereço da organizadora
     * @return o endereço da organizadora
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Método criarEvento para o Evento Festival
     * @param nome o nome do Evento
     * @param local o local do Evento
     * @param precoIngresso o preço do Ingresso do Evento
     * @param organizadora a organizadora do Evento
     * @param data a data do Festival
     * @param lineup a lista com os nomes dos artistas do Festival
     * @param duracao a duração do Festival
     * @return novo Evento Festival
     */
    public EventoFestival criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, List<String> lineup, int duracao) {
        EventoFestival evento = new EventoFestival(nome, local, precoIngresso, organizadora, data, lineup, duracao);
        eventos.add(evento);
        return evento;
    }

    /**
     * Método criarEvento para o Evento Jogo
     * @param nome o nome do Evento
     * @param local o local do Evento
     * @param precoIngresso o preço do Ingresso do Evento
     * @param organizadora a organizadora do Evento
     * @param data a data do Evento
     * @param times lista com os nomes dos times que se enfrentam no Evento
     * @return novo Evento Jogo
     */
    public EventoJogo criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, List<String> times) {
        EventoJogo evento = new EventoJogo(nome, local, precoIngresso, organizadora, data, times);
        eventos.add(evento);
        return evento;
    }

    /**
     * Método criarEvento para o Evento Show
     * @param nome o nome do Evento
     * @param local o local do Evento
     * @param precoIngresso o preço do Ingresso do Evento
     * @param artista o artista do Evento
     * @param organizadora a organizadora do Evento
     * @return novo Evento Show
     */
    public EventoShow criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, String artista) {
        EventoShow evento = new EventoShow(nome, local, precoIngresso, organizadora, data, artista);
        eventos.add(evento);
        return evento;
    }

    /**
     * Busca eventos da organizadora com base em filtros específicos
     * @param filtro o filtro utilizado na busca
     * @return a lista de eventos que satisfazem o filtro
     */
    public List<Evento> buscarEventos(Filter<Evento> filtro) {
        return filtro.meetCriteria(eventos);
    }
}
