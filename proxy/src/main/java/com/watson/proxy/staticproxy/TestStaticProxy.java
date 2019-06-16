package com.watson.proxy.staticproxy;

import com.watson.proxy.staticproxy.fatherson.Father;
import com.watson.proxy.staticproxy.fatherson.Son;

public class TestStaticProxy {
    public static void main(String[] args) {
        new Father(new Son()).findLove();
    }
}
