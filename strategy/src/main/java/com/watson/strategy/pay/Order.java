package com.watson.strategy.pay;

import com.watson.strategy.pay.payport.PayStrategy;
import com.watson.strategy.pay.payport.Payment;

public class Order {
    private String uid;
    private String orderId;
    private double amout;

    public Order(String uid, String orderId, double amout) {
        this.uid = uid;
        this.orderId = orderId;
        this.amout = amout;
    }
    public MsgResult pay(String payKey){
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用"+payment.getName());
        System.out.println("本次交易金额为："+amout+",开始扣款...");
        return payment.pay(uid, amout);
    }
}
