package com.watson.decorator.pancake;

public class PancakeDecoratorTest {
    public static void main(String[] args) {
        BasePancake pancake;
        pancake = new BasePancake();
        pancake = new EggDecorator(pancake);
        pancake = new EggDecorator(pancake);
        pancake = new HotdogDecorator(pancake);
        System.out.println(pancake.getMsg()+"，价格："+pancake.getPrice());
    }
}
