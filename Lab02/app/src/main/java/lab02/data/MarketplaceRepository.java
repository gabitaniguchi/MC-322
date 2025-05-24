package lab02.data;

import lab02.model.Marketplace;

public class MarketplaceRepository {

    private static Marketplace marketplace = new Marketplace(15.0);

    public static Marketplace getMarketplace(){
        return marketplace;
    }
    
}
