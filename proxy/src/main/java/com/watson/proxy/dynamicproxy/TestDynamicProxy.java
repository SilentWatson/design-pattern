package com.watson.proxy.dynamicproxy;

import com.watson.proxy.Person;
import com.watson.proxy.dynamicproxy.jdkproxy.Girl;
import com.watson.proxy.dynamicproxy.jdkproxy.MatrimonialAgency;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void main(String[] args) {
        ((Person)(new MatrimonialAgency(new Girl()).getInstance())).findLove();
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E://$Proxy0.class");
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
