/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02.model;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    protected String nome;
    protected Local local;
    protected double precoIngresso; // preço base do ingresso
    protected Organizadora organizadora;
    protected String data;
    protected List<Ingresso> ingressosVendidos;
    protected boolean cancelado;
    protected List<Cliente> clientes;
    protected List<CaracteristicaDeEvento> caracteristicas;

    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     * @param precoIngresso o preço base do ingresso
     * @param organizadora a organizadora do Evento
     * @param data a data do evento
     */
    public Evento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data) {
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso; // modificar para representar o preço base do ingresso
        this.organizadora = organizadora;
        this.data = data;
        this.ingressosVendidos = new ArrayList<>();
        this.cancelado = false;
        this.clientes = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
    }

    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do Evento para `nome` 
     * @param nome o novo nome do Evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o Local do Evento
     * @return o local do Evento
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Altera o local do Evento para `local` 
     * @param local o novo local do Evento
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public double getPrecoIngresso(){
        return this.precoIngresso;
    }
    
    /**
     * Retorna a orgaizadora do Evento
     * @return a organizadora do Evento
     */
    public Organizadora getOrganizadora(){
        return organizadora;
    }

    /**
     * Altera o precoIngresso do Evento para `precoIngresso` 
     * @param precoIngresso o novo precoIngresso do Evento
     */
    public void setPrecoIngresso(double precoIngresso){
        try{
            // se o preço é negativo é inválido e lança exceção
            if(precoIngresso < 0){
                throw new IllegalArgumentException("Preço inválido");
            }

            this.precoIngresso = precoIngresso;
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void descricao(){
        System.out.println("Evento: " + this.nome + " - Local: " + this.local.getNome() + " - Data " + data);
        for (CaracteristicaDeEvento c : caracteristicas) {
            System.out.println("- " + c.descricao());
        }
    }

    /**
     * Retorna a data do Evento
     * @return a data do Evento
     */
    public String getData() {
        return data;
    }

    /**
     * Cancela o evento e os ingressos dos clientes daquele evento
     * @param dataAtual a data do cancelamento
     */
    public void cancelarEvento(String dataAtual){
        this.cancelado = true;
        // cancela os ingressos de todos os clientes que compraram o evento
        for(Cliente cliente: clientes){
            cliente.cancelarIngresso(this, dataAtual);
        }
        
    }

    /**
     * Retorna se o evento foi cancelado ou não
     * @return se o evento foi cancelado
     */
    public boolean getCancelamento(){
        return cancelado;
    }

    /**
     * Exceção referente ao número de ingressos disponíveis
     */
    public class IngressosEsgotadosException extends Exception{
        public IngressosEsgotadosException(String mensagem) {
            super(mensagem);
        }
    }

    /**
     * Exceção referente a disponibilidade do evento 
     * Se o evento for cancelado lança uma exceção
     */
    public class EventoIndisponivelException extends Exception{
        public EventoIndisponivelException(String mensagem) {
            super(mensagem);
        }
    }

    /**
     * Atribui o ingresso como vendido ao cliente
     * @param cliente o cliente que comprou o ingresso
     */
    public void venderIngresso(Cliente cliente){
        try{
            // se os ingressos esgotaram, lança um erro
            if(this.ingressosVendidos.size() >= this.local.getCapacidade()){
                throw new IngressosEsgotadosException("Ingressos Esgotados");
            }

            // se o evento está cancelado, lança um erro
            if(this.cancelado) {
                throw new EventoIndisponivelException("Evento Indisponível");
            }

            Ingresso ingresso = new Ingresso(this, this.precoIngresso);
            this.ingressosVendidos.add(ingresso);

        } catch (IngressosEsgotadosException e){
            System.out.println(e.getMessage());
        } catch (EventoIndisponivelException e){
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * Retorna a lista de ingressos vendidos do evento
     * @return lista de ingressos vendidos 
     */
    public List<Ingresso> getIngressosVendidos(){
        return ingressosVendidos;
    }

    /**
     * Adiciona Características de Evento específicas, seguindo a noção de composição
     * @param caracteristica a característica a ser adicionada
     */
    public void adicionarCaracteristica(CaracteristicaDeEvento caracteristica){
        this.caracteristicas.add(caracteristica);
    }

    /**
     * Retorna algum tipo de característica específica do evento para que seja possível acessar seu atributos
     * @param caracateristica a característica a ser retornada
     * @return a característica de evento específica, ou null se o evento não a possuir
     */
    public CaracteristicaDeEvento getCaracteristica(CaracteristicaDeEvento caracateristica){
        for(CaracteristicaDeEvento caracteristicaEvento: caracteristicas){
            if(caracteristicaEvento.equals(caracateristica)){
                return caracteristicaEvento;
            }
        }

        return null;
    }

}