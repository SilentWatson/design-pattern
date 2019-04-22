package com.watson.proxy.dynamicproxy.watsonproxy;

import com.watson.proxy.staticproxy.IPerson;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WatsonMeiPo implements WatsonInvocationHandler {
    private IPerson person;
    public Object getInstance(IPerson person){
        this.person = person;
        Class<?> clazz = person.getClass();
        return WatsonProxy.newProxyInstance(new WatsonClassLoader(),clazz.getInterfaces(),this);

    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.person, args);
        after();
        return obj;
    }
    private void before(){
        System.out.println("我是媒婆，确认了你的需求，开始物色");
    }
    private void after(){
        System.out.println("OK的话，就准备办事吧！");
    }
}
