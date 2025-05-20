package lab02;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {

    private List<OfertaIngresso> ingressossAVenda;
    private double comissaoPorcentagem;

    public Marketplace(double comissaoPorcentagem){
        this.ingressossAVenda = new ArrayList<>();
        this.comissaoPorcentagem = comissaoPorcentagem;
    }

    /**
     * Retorna a lista de ingressos/ofertas disponiveis no marketplace
     * @return
     */
    public List<OfertaIngresso> listarOrfertas(){
        return ingressossAVenda;
    }

    public void receberOferta(Ingresso ingresso, double precoPedido, Cliente vendedor){
        ingressossAVenda.add(new OfertaIngresso(ingresso, precoPedido, vendedor));
    }

    public void processarCompra(Cliente comprador, OfertaIngresso oferta){
        ingressossAVenda.remove(oferta);

        oferta.getVendedor().removerIngresso(oferta.getIngresso());
        comprador.adicionarIngresso(oferta.getIngresso());

        double comissao = (comissaoPorcentagem/100)*oferta.getPrecoPedido();
        double valorRecebidoVendedor = oferta.getPrecoPedido() - comissao;
    
        oferta.getVendedor().creditar(valorRecebidoVendedor);
        comprador.creditar(-oferta.getPrecoPedido());

        // Notificações (se configuradas)
        oferta.getVendedor().todasNotificacoes("Seu ingresso foi vendido por R$" + oferta.getPrecoPedido());
        comprador.todasNotificacoes("Você comprou um ingresso para o evento " + oferta.getIngresso().getEvento().getNome());
    }
    
}
