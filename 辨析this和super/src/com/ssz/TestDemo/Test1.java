package com.ssz.TestDemo;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-02 7:54
 */
class Teacher{
    public String name;
    public int age;
    public String nickName;

    public Teacher(String name, int age, String nickName) {
        this.name = name;
        this.age = age;
        this.nickName = nickName;
        System.out.println("父类的构造方法");
    }

}
class Student extends Teacher{
    public String studentId;
    public Student(String name, int age, String nickName, String studentId) {
        super(name, age, nickName);
        this.studentId = studentId;
        System.out.println("子类的构造方法");
    }

}
public class Test1 {
    public static void main(String[] args) {
        Student student = new Student("h",11,"g","1234");

    }
}
