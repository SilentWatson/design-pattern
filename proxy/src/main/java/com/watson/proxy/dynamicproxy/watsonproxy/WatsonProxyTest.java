package com.watson.proxy.dynamicproxy.watsonproxy;

import com.watson.proxy.dynamicproxy.jdkproxy.Girl;
import com.watson.proxy.dynamicproxy.jdkproxy.JDKMeiPo;
import com.watson.proxy.staticproxy.IPerson;

public class WatsonProxyTest {
    public static void main(String[] args) {
        IPerson person = (IPerson)new WatsonMeiPo().getInstance(new Girl());
        person.findLove();
    }
}
