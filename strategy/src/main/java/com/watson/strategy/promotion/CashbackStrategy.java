package com.watson.strategy.promotion;

public class CashbackStrategy implements IPromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("直接返现");
    }
}
