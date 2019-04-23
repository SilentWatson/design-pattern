package com.watson.strategy.promotion;

public class GroupbuyStrategy implements IPromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("满20团，全团享受价格");
    }
}
