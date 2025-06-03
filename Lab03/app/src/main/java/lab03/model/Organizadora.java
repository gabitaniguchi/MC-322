package lab03.model;
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

    public void adicionarEvento(Evento evento){
        eventos.add(evento);
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
