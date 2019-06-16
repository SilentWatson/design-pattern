package com.watson.proxy.dynamicproxy.jdkproxy;

import com.watson.proxy.Person;

public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("女孩要求：高富帅");
    }
}
