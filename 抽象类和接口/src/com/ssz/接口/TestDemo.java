package com.ssz.接口;

/**
 *接口(Interface):
 * (1)接口当中的方法都是抽象方法,都不能被实现
 * (2)在jdk1.8以后,接口可以有具体的实现方法(需要被default修饰)
 * (3)接口中定义的成员变量默认是常量(public static final)
 * 接口中定义的方法默认是抽象方法(public abstract)
 * (4)接口中定义的常量必须初始化
 * (5)接口不可以被实例化
 * (6)接口不能被继承，要用implements实现;
 * (7)为了解决单继承问题,接口可以实现多个接口;
 * (8)只要类实现了接口就可以进行向上转型
 */

interface Shape{
    public abstract void draw();

}
interface A{

}
class Cycle implements Shape,A {
    @Override
    public void draw(){
        System.out.println("画一个○");
    }
}
class React implements Shape {
    @Override
    public void draw(){
        System.out.println("画一个□");
    }
}
class Flower implements Shape {
    @Override
    public void draw(){
        System.out.println("画一朵❀");
    }
}

public class TestDemo {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        Shape shape2 = new Flower();
        drawMap(shape1);
        drawMap(shape2);
    }
}
