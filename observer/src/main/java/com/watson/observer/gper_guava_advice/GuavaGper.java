package com.watson.observer.gper_guava_advice;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.watson.observer.gperadvice.Question;

public class GuavaGper{
    private EventBus eventBus = new EventBus();
    private String name = "Gper生态圈";
    private static GuavaGper gper = null;
    private GuavaGper(){}
    public static GuavaGper getInstance(){
        if(gper==null){
            synchronized (GuavaGper.class){
                if(gper==null){
                    gper = new GuavaGper();
                }
            }
        }
        return gper;
    }
    public String getName() {
        return name;
    }
    public void publishQuestion(Question question){
        System.out.println(question.getUserName()+"在"+this.name+"上交了一个问题。");
        eventBus.post(question);
    }
    public void addTeacher(Object teacher){
        eventBus.register(teacher);
    }

}
