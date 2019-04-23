package com.watson.strategy.promotion;

public class EmptyStrategy implements IPromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
