package com.watson.strategy.pay;

import com.watson.strategy.pay.payport.PayStrategy;

public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "2019042300001", 324.45);
        MsgResult result = order.pay(PayStrategy.UNION_PAY);
        System.out.println(result.toString());
    }
}
