package com.watson.proxy.dynamicproxy.jdkproxy;

import com.watson.proxy.staticproxy.IPerson;

public class JDKProxyTest {
    public static void main(String[] args) {
        IPerson person = (IPerson)new JDKMeiPo().getInstance(new Girl());
        person.findLove();
    }
}
