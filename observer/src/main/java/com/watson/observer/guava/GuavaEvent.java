package com.watson.observer.guava;
import com.google.common.eventbus.Subscribe;

public class GuavaEvent {
    @Subscribe
    public void subscribe(String str){
        System.out.println("执行sbuscribe方法，传入参数是："+str);
    }
}
