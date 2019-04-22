package com.watson.delegate.simple;

public class EmployeeB implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我擅长做架构，开始干活，执行"+ command);
    }
}
