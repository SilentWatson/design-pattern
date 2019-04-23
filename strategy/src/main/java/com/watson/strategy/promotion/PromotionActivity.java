package com.watson.strategy.promotion;

public class PromotionActivity {

    private IPromotionStrategy promotionStrategy;
    public PromotionActivity(IPromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        this.promotionStrategy.doPromotion();
    }
}
