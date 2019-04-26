package com.watson.observer.gper_guava_advice;

import com.google.common.eventbus.Subscribe;
import com.watson.observer.gperadvice.Question;


public class GuavaTeacher {
    private String name;
    public GuavaTeacher(String name) {
        this.name = name;
    }
    @Subscribe
    public void subscribe(Question question) {
        System.out.println("=======================");
        System.out.println(this.name+"老师,你好!\n你收到了来自Gper生态圈的提问，希望你解答，问题内容如下:\n"+question.getContent()+"\n提问者是："+question.getUserName());
    }

}
