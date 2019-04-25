package com.watson.decorator.pancake;

public class EggDecorator extends PancakeDecorator{
    public EggDecorator(BasePancake basePancake) {
        super(basePancake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }

    @Override
    protected void doSomething() {

    }
}
