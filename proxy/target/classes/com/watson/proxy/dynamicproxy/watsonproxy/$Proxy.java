package com.watson.proxy.dynamicproxy.watsonproxy;
import com.watson.proxy.staticproxy.IPerson;
import java.lang.reflect.*;
public class $Proxy0 implements com.watson.proxy.staticproxy.IPerson{
WatsonInvocationHandler h;
public $Proxy0(WatsonInvocationHandler h){
this.h = h;
}
public void findLove(){
try{
Method m = com.watson.proxy.staticproxy.IPerson.class.getMethod("findLove", new Class[]{});this.h.invoke(this, m, null);
}catch(Throwable e){
e.printStackTrace();
}
}
}
