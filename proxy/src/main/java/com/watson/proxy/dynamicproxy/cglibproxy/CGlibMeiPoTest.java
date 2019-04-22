package com.watson.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class CGlibMeiPoTest {
    public static void main(String[] args) {
        try {
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E://cglib_proxy_classes");
            Customer obj = (Customer)new CGlibMeiPo().getInstance(Customer.class);
            System.out.println(obj);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
