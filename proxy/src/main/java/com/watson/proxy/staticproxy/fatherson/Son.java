package com.watson.proxy.staticproxy.fatherson;

import com.watson.proxy.Person;

public class Son implements Person {
    @Override
    public void findLove(){
        System.out.println("儿子要求：肤白貌美大长腿");
    }
}
