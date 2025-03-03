package com.springioc.mode2;

public class Main {
//    采用IoC思想,把类对象放到不相关的容器中(main),
    public static void main(String[] args) {
        D d = new D(17, "red");
        C c = new C(d);
        B b = new B(c);
        A a = new A(b);
        a.run();

    }
}
class A {
    private B b;
    public A(B b){
//        A依赖B
        this.b= b;
        System.out.println("A...");
    }
    public void run(){
        System.out.println("A run ...");
    }
}

class B {
    private C c;
    public B(C c){
//        B依赖C
        this.c = c;
        System.out.println("B...");
    }
}
class C {
    private D d;
    public C(D d){
//        C依赖D
        this.d = d;
        System.out.println("C...");
    }
}
class D {
    private int size;
    private String color;

    public D(int size){
        this.size=size;
        System.out.println("D.size:"+this.size);
    }
    public D(int size, String color) {
        this.size = size;
        this.color = color;
        System.out.println("D.size:"+this.size+" color: "+color);

    }


}