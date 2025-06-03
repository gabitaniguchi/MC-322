/*
 * Ingresso.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

 package lab03.model;

/**
 * Contém a estrutura de implementação de um Ingresso.
 */
public class Ingresso {

    private Evento evento;
    private double preco;
    private boolean vendendo;

    /**
     * Construtor da classe Ingresso
     * @param preco o preço do Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public Ingresso(Evento evento, double preco) {
        this.evento = evento;
        this.preco = preco;
        this.vendendo = false;
    }

    public void setVendendo(boolean vendendo){
        this.vendendo = vendendo;
    }

    public boolean getVendendo(){
        return this.vendendo;
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */
    public double getPreco() {

        return this.preco;
    }

    /**
     * Define o evento associado ao Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * Retorna o evento do ingresso
     * @return o evento do ingresso
     */
    public Evento getEvento(){
        return this.evento;
    }
}
