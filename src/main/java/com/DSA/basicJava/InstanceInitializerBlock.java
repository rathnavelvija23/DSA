package com.DSA.basicJava;

public class InstanceInitializerBlock {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
        InstanceInitializerBlock mc = new InstanceInitializerBlock();
       A a = new A();
        System.out.println("  "+a.hashCode());

        System.out.println("Deserialliztion "+a.clone().hashCode());

       Class<?> aclass = Class.forName("com.DSA.basicJava.A");
        System.out.println("class "+aclass.newInstance().hashCode());


    }

    // Instance initializer block
    // Code to be executed when an instance is created
    {
        Three three = new Three(); // One,Two,Three
    }
}

class One {
     public One() {
        System.out.print("One,");
    }
}

class Two extends One {
    public Two() {
        System.out.print("Two,");
    }
}

class Three extends Two {
    public Three() {
        System.out.print("Three");
    }
}

class A implements Cloneable{
    static void print(){
        System.out.println("Final method");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class B extends A{
       static void print() {
        System.out.println("Child method");
    }
}