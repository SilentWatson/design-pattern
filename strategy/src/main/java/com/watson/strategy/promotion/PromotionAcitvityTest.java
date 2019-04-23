package com.watson.strategy.promotion;


import org.apache.commons.lang3.StringUtils;

public class PromotionAcitvityTest {
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = new PromotionActivity(new CouponStrategy());
//        promotionActivity.execute();
//    }
//public static void main(String[] args) {
//    PromotionActivity promotionActivity = null;
//    String promotionKey = "COUPON";
//    if(StringUtils.equals(promotionKey, "COUPON")){
//        promotionActivity = new PromotionActivity(new CouponStrategy());
//    }else if(StringUtils.equals(promotionKey, "CASHBACK")){
//        promotionActivity = new PromotionActivity(new CashbackStrategy());
//    }//...
//    promotionActivity.execute();
//
//
//}
public static void main(String[] args) {
    String promotionKey = "GROUPBUY";
    PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
    promotionActivity.execute();
}
}
