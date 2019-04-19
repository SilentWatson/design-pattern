package com.watson.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA();
        prototypeA.setAge(18);
        prototypeA.setName("Watson");
        List hobbies = new ArrayList<String>();
        prototypeA.setHobbies(hobbies);
        Client client = new Client(prototypeA);
        ConcretePrototypeA copy = (ConcretePrototypeA)client.startClone();
        System.out.println(copy);
        System.out.println("克隆对象中引用类型的地址"+copy.getHobbies());
        System.out.println("原来对象中引用类型的地址"+prototypeA.getHobbies());
        System.out.println("引用类型的地址比较："+(copy.getHobbies()==prototypeA.getHobbies()));
    }
}
