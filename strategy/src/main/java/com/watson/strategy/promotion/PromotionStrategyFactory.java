package com.watson.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {

    private static Map<String,IPromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
    static{
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK, new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY, new GroupbuyStrategy());
    }
    private static final IPromotionStrategy NON_PROMOTION = new EmptyStrategy();

    private PromotionStrategyFactory(){}
    public static IPromotionStrategy getPromotionStrategy(String promotionKey){
        IPromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null? NON_PROMOTION:promotionStrategy;
    }
    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }
}
