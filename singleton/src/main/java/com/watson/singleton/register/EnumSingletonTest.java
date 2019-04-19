package com.watson.singleton.register;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingletonTest {
//    public static void main(String[] args) {
//        EnumSingleton enumSingleton = EnumSingleton.getInstance();
//        enumSingleton.setData(1);
//        System.out.println(enumSingleton.getData());
//        EnumSingleton enumSingleton1 = EnumSingleton.getInstance();
//        System.out.println(enumSingleton1.getData());
//    }
public static void main(String[] args) {
    Class clazz = EnumSingleton.class;
    try {
        Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
        c.setAccessible(true);
        c.newInstance("watson", 666);
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }
}
}
