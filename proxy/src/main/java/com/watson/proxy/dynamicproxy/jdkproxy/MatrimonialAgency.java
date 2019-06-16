package com.watson.proxy.dynamicproxy.jdkproxy;

import com.watson.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MatrimonialAgency implements InvocationHandler {
    private Person target;

    public MatrimonialAgency(Person target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }
    public Object getInstance(){
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    private void before(){
        System.out.println("中介为你物色对象中");
    }
    private void after(){
        System.out.println("可以的话就交往呀");
    }
}
