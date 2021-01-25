package com.ssz.抽象类;

/**
 * 抽象类:
 * 1、抽象方法:如果一个方法被abstract修饰,那么这个方法就是抽象方法；抽象方法可以没有具体的实现!
 * 2、包含抽象方法的类是抽象类(需要被abstract修饰);
 * 注意事项:
 * (1)抽象类不可以被实例化
 * (2)类内可以有普通方法和成员变量
 * (3)抽象类主要是被用来实现继承的;
 * (4)如果某个类继承了抽象类,必须要重写抽象方法
 * (5)当抽象类A继承抽象类B,A中可以不重写B的抽象方法；一旦有其它类继承A,则必须重写B中的抽象方法
 * */
abstract class Shape{
    public abstract void draw();//抽象方法
    private int age;//普通成员变量
    //普通方法
    public void func1(){

    }
}
class Cycle extends Shape{
    @Override
    public void draw(){
        System.out.println("画一个○");
    }
}
class React extends Shape{
    @Override
    public void draw(){
        System.out.println("画一个□");
    }
}
class Flower extends Shape{
    @Override
    public void draw(){
        System.out.println("画一朵❀");
    }
}
class Triangle extends Shape{
    @Override
    public void draw(){
        System.out.println("画一个△");
    }
}
//当抽象类C继承抽象类Shape,A中可以不重写B的抽象方法；
abstract class C extends Shape{

}
class D extends C{
    @Override
    public void draw(){
        System.out.println("当且D继承C时，需要重写Shape抽象方法");
    }
}
public class TestDemo {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        //Shape shape = new Shape() ;(不可行，抽象类不能被实例化)
        //通过向上转型实例化
        Shape shape = new Cycle();
        Shape shape1 = new Flower();
        drawMap(shape);
    }

}
