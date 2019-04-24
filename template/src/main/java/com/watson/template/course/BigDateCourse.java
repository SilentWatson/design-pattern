package com.watson.template.course;

public class BigDateCourse extends NetworkCourse{
    private boolean needHomeworkFlag = false;

    public BigDateCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    protected void checkHomework() {
        System.out.println("检查大数据课后作业");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
