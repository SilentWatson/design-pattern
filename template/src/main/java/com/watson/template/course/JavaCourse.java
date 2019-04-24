package com.watson.template.course;

public class JavaCourse extends NetworkCourse{
    @Override
    protected void checkHomework() {
        System.out.println("检查Java的架构作业");
    }
}
