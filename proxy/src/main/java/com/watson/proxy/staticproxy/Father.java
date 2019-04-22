package com.watson.proxy.staticproxy;

public class Father implements IPerson {
    private Son son;
    public Father(Son son){
        this.son = son;
    }
    public void findLove(){
        System.out.println("父亲物色对象");
        this.son.findLove();
        System.out.println("双方父母同意，确立关系");
    }
}
