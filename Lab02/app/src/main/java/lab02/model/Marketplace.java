package lab02.model;
import java.util.ArrayList;
import java.util.List;

public class Marketplace {

    private List<OfertaIngresso> ingressossAVenda;
    private double comissaoPorcentagem;
    private double lucro;

    public Marketplace(double comissaoPorcentagem){
        this.ingressossAVenda = new ArrayList<>();
        this.comissaoPorcentagem = comissaoPorcentagem;
        this.lucro = 0;
    }

    public void adicionarLucro(double valor){
        this.lucro += valor;
    }

    public double getLucro(){
        return lucro;
    }

    public double getComissao(){
        return comissaoPorcentagem;
    }

    /**
     * Retorna a lista de ingressos/ofertas disponiveis no marketplace
     * @return
     */
    public List<OfertaIngresso> listarOfertas(){
        return ingressossAVenda;
    }

    public void receberOferta(Ingresso ingresso, double precoPedido, Cliente vendedor, boolean oficial){
        ingressossAVenda.add(new OfertaIngresso(ingresso, precoPedido, vendedor, oficial));
    }

    public void processarCompra(Cliente comprador, OfertaIngresso oferta){
        ingressossAVenda.remove(oferta);

        oferta.getVendedor().removerIngresso(oferta.getIngresso());
        comprador.adicionarIngresso(oferta.getIngresso());

        double comissao = (comissaoPorcentagem/100)*oferta.getPrecoPedido();
        double valorRecebidoVendedor = oferta.getPrecoPedido() - comissao;
        adicionarLucro(comissao);
    
        oferta.getVendedor().creditar(valorRecebidoVendedor);
        comprador.creditar(-oferta.getPrecoPedido());

        // Notificações (se configuradas)
        oferta.getVendedor().todasNotificacoes("Seu ingresso foi vendido por R$" + oferta.getPrecoPedido());
        comprador.todasNotificacoes("Você comprou um ingresso para o evento " + oferta.getIngresso().getEvento().getNome());
    }
    
}
