package com.springioc.mode1;

public class Main {
    public static void main(String[] args) {
        A a = new A(17);
        a.run();
        A a1 = new A(20);
        a.run();

    }
}
class A {
    private B b;
    public A(int size){
//        A依赖B
        b=new B(size);
        System.out.println("A...");
    }
    public void run(){
        System.out.println("A run ...");
    }
}

class B {
    private C c;
    public B(int size){
//        B依赖C
        c = new C(size);
        System.out.println("B...");
    }
}
class C {
    private D d;
    public C(int size){
//        C依赖D
        d = new D(size);
        System.out.println("C...");
    }
}
class D {
    private int size;
    public D(int size){
        this.size=size;
        System.out.println("D.size:"+this.size);
    }
}