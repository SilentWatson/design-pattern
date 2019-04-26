package com.watson.observer.gper_guava_advice;

import com.watson.observer.gperadvice.Question;

public class GuavaGperTest {
    public static void main(String[] args) {
        GuavaGper guavaGper = GuavaGper.getInstance();
        GuavaTeacher watson = new GuavaTeacher("Watson");
        guavaGper.addTeacher(watson);
        Question question = new Question();
        question.setUserName("xxj");
        question.setContent("观察者设计模式适用于哪些场景?");
        guavaGper.publishQuestion(question);
    }
}
