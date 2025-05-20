package lab02;

public class OfertaIngresso {

    private Ingresso ingresso;
    private double precoPedido;
    private Cliente vendedor;

    public OfertaIngresso(Ingresso ingresso, double precoPedido, Cliente vendedor) {
        this.ingresso = ingresso;
        this.precoPedido = precoPedido;
        this.vendedor = vendedor;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public double getPrecoPedido() {
        return precoPedido;
    }

    public Cliente getVendedor() {
        return vendedor;
    }

}
