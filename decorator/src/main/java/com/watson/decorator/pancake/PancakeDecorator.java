package com.watson.decorator.pancake;

public abstract class PancakeDecorator extends BasePancake {
    private Pancake basePancake;
    public PancakeDecorator(Pancake basePancake){
        this.basePancake = basePancake;
    }
    @Override
    protected String getMsg() {
        return this.basePancake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.basePancake.getPrice();
    }
    protected abstract void doSomething();
}
