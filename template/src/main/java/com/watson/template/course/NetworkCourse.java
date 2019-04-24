package com.watson.template.course;

public abstract class NetworkCourse {
    protected final void createCourse(){
        //发布预习资料
        this.postPreResource();
        //制作ppt
        this.createPPT();
        //在线直播
        this.liveViedo();
        //提交课件、课堂笔记
        this.postNote();
        //提交源代码
        this.postSource();
        //布置作业,有些课没有作业，有些课是有作业的
        //如果有作业，老师还要检查作业
        if(needHomework()){
            checkHomework();
        }


    }

    protected abstract void checkHomework();

    protected  boolean needHomework(){
        return false;
    }

    final void postSource(){
        System.out.println("上传源码");
    }

    final void postNote(){
        System.out.println("提交课件和笔记");
    }

    final void liveViedo(){
        System.out.println("在线直播");
    }

    final void createPPT(){
        System.out.println("制作备课ppt");
    }

    final void postPreResource(){
        System.out.println("分发预习资料");
    }
}
