package lab02.model;

public class OfertaIngresso {

    private Ingresso ingresso;
    private double precoPedido;
    private Cliente vendedor;
    private boolean oficial;

    public OfertaIngresso(Ingresso ingresso, double precoPedido, Cliente vendedor, boolean oficial) {
        this.ingresso = ingresso;
        this.precoPedido = precoPedido;
        this.vendedor = vendedor;
        this.oficial = oficial;
    }

    public boolean getOficial(){
        return oficial;
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
