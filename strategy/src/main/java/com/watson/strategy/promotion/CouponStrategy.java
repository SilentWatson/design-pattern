package com.watson.strategy.promotion;

public class CouponStrategy implements IPromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，课程价格直接减去优惠券");
    }
}
