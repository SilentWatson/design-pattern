package com.watson.observer.gperadvice;

public class GperAdviceTest {
    public static void main(String[] args) {
        Gper gper = Gper.getInstance();
        Teacher watson = new Teacher("Watson");
        gper.addObserver(watson);
        Question question = new Question();
        question.setUserName("xxj");
        question.setContent("观察者设计模式适用于哪些场景?");
        gper.publishQuestion(question);
    }
}
