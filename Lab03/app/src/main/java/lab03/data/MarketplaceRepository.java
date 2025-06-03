package lab03.data;

import lab03.model.Marketplace;

/**
 * Repositório responsável por fornecer acesso à instância do Marketplace.
 */
public class MarketplaceRepository {

    // Instância única do marketplace com 15% de comissão
    private static Marketplace marketplace = new Marketplace(15.0);

    /**
     * Retorna a instância atual do marketplace.
     * @return instância do Marketplace
     */
    public static Marketplace getMarketplace() {
        return marketplace;
    }
}
