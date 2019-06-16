package com.watson.proxy.staticproxy.fatherson;

import com.watson.proxy.Person;

public class Father implements Person {
    private Person son;

    public Father(Son son) {
        this.son = son;
    }
    @Override
    public void findLove(){
        System.out.println("父亲物色对象");
        son.findLove();
        System.out.println("双方父母同意，确立关系");
    }
}
