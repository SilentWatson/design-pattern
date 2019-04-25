package com.watson.decorator.pancake;

public class HotdogDecorator extends PancakeDecorator{
    public HotdogDecorator(BasePancake basePancake) {
        super(basePancake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1根火腿";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+2;
    }

    @Override
    protected void doSomething() {

    }
}
