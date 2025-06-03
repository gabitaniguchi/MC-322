package lab03.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o marketplace onde os clientes podem comprar e vender ingressos.
 */
public class Marketplace {

    private List<OfertaIngresso> ingressossAVenda;
    private double comissaoPorcentagem;
    private double lucro;

    /**
     * Construtor da classe Marketplace.
     * @param comissaoPorcentagem a porcentagem de comissão cobrada sobre cada venda
     */
    public Marketplace(double comissaoPorcentagem){
        this.ingressossAVenda = new ArrayList<>();
        this.comissaoPorcentagem = comissaoPorcentagem;
        this.lucro = 0;
    }

    /**
     * Adiciona um valor ao lucro total do marketplace.
     * @param valor o valor a ser adicionado ao lucro
     */
    public void adicionarLucro(double valor){
        this.lucro += valor;
    }

    /**
     * Retorna o lucro total obtido pelo marketplace.
     * @return o lucro acumulado
     */
    public double getLucro(){
        return lucro;
    }

    /**
     * Retorna a porcentagem de comissão aplicada pelo marketplace.
     * @return a comissão em porcentagem
     */
    public double getComissao(){
        return comissaoPorcentagem;
    }

    /**
     * Retorna a lista de ofertas de ingressos atualmente disponíveis no marketplace.
     * @return a lista de ofertas de ingresso à venda
     */
    public List<OfertaIngresso> listarOfertas(){
        return ingressossAVenda;
    }

    /**
     * Registra uma nova oferta de ingresso no marketplace.
     * @param ingresso o ingresso a ser ofertado
     * @param precoPedido o preço solicitado pelo ingresso
     * @param vendedor o cliente que está oferecendo o ingresso
     * @param oficial indica se a oferta é oficial (venda direta do sistema)
     */
    public void receberOferta(Ingresso ingresso, double precoPedido, Cliente vendedor, boolean oficial){
        ingressossAVenda.add(new OfertaIngresso(ingresso, precoPedido, vendedor, oficial));
    }

    /**
     * Processa a compra de uma oferta de ingresso por um cliente.
     * Remove a oferta do marketplace, transfere o ingresso ao comprador,
     * calcula a comissão, credita o valor ao vendedor e notifica as partes envolvidas.
     * @param comprador o cliente que está comprando o ingresso
     * @param oferta a oferta que está sendo comprada
     */
    public void processarCompra(Cliente comprador, OfertaIngresso oferta){
        ingressossAVenda.remove(oferta);

        oferta.getVendedor().removerIngresso(oferta.getIngresso());
        comprador.adicionarIngresso(oferta.getIngresso());

        double comissao = (comissaoPorcentagem / 100) * oferta.getPrecoPedido();
        double valorRecebidoVendedor = oferta.getPrecoPedido() - comissao;
        adicionarLucro(comissao);

        oferta.getVendedor().creditar(valorRecebidoVendedor);
        comprador.creditar(-oferta.getPrecoPedido());
    }

}
