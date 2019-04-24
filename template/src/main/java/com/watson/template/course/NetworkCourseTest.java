package com.watson.template.course;

public class NetworkCourseTest {
    public static void main(String[] args) {
        System.out.println("java架构师课程");
        NetworkCourse java = new JavaCourse();
        java.createCourse();
        NetworkCourse bigDateCourse = new BigDateCourse(true);
        bigDateCourse.createCourse();
    }
}
