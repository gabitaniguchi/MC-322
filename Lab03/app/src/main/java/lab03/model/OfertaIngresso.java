package lab03.model;

/**
 * Representa uma oferta de ingresso que pode ser feita por um cliente no marketplace.
 */
public class OfertaIngresso {

    private Ingresso ingresso;
    private double precoPedido;
    private Cliente vendedor;
    private boolean oficial;

    /**
     * Construtor da classe OfertaIngresso.
     * @param ingresso o ingresso que está sendo ofertado
     * @param precoPedido o preço solicitado pelo ingresso
     * @param vendedor o cliente que está vendendo o ingresso
     * @param oficial indica se a oferta é oficial (venda direta do sistema)
     */
    public OfertaIngresso(Ingresso ingresso, double precoPedido, Cliente vendedor, boolean oficial) {
        this.ingresso = ingresso;
        this.precoPedido = precoPedido;
        this.vendedor = vendedor;
        this.oficial = oficial;
    }

    /**
     * Retorna se a oferta é oficial ou não.
     * @return true se for uma oferta oficial, false caso contrário
     */
    public boolean getOficial(){
        return oficial;
    }

    /**
     * Retorna o ingresso associado à oferta.
     * @return o ingresso ofertado
     */
    public Ingresso getIngresso() {
        return ingresso;
    }

    /**
     * Retorna o preço pedido pelo ingresso.
     * @return o valor solicitado pela oferta
     */
    public double getPrecoPedido() {
        return precoPedido;
    }

    /**
     * Retorna o cliente vendedor do ingresso.
     * @return o cliente que fez a oferta
     */
    public Cliente getVendedor() {
        return vendedor;
    }

}
