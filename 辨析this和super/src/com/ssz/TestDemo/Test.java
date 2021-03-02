package com.ssz.TestDemo;
class Game{
    private String name;
    private String role;
    private int id;

    public Game() {
        System.out.println("父类的无参构造方法");
    }

    public Game(String name, String role, int id) {
        //this调用本类构造方法,必须放在第一行
        this.name = name;
        this.role = role;
        this.id = id;
        System.out.println("父类的有参数构造方法");
    }
}
class WangZhe extends Game{
    private String stage;
    private String relation;
    public WangZhe() {
        System.out.println("子类的无参构造方法");
    }

    public WangZhe(String name, String role, int id,String stage) {
        //super调用父类的构造方法,必须放在子类构造方法的第一行
        super(name, role, id);
        this.stage = stage;
        System.out.println("子类的有参数构造方法");
    }
    public WangZhe(String name, String role, int id,String stage,String relation){
        this(name, role, id, stage);
        this.relation = relation;
        System.out.println("调用this()");
    }
}
public class Test {
    public static void main(String[] args) {
        WangZhe w = new WangZhe();
        WangZhe w1 = new WangZhe("蔡文姬","辅助",1,"倔强青铜","cp");
    }
}
