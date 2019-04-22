package com.watson.proxy.dynamicproxy.watsonproxy;

import java.lang.reflect.Method;

public interface WatsonInvocationHandler {
     Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
