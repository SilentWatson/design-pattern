package com.watson.observer.gperadvice;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {
    private String name;
    public Teacher(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        Gper gper = (Gper)o;
        Question question = (Question)arg;
        System.out.println("=======================");
        System.out.println(this.name+"老师,你好!\n你收到了来自"+gper.getName()+"的提问，希望你解答，问题内容如下:\n"+question.getContent()+"\n提问者是："+question.getUserName());
    }
}
