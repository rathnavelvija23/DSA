package com.Test;

public class Singleton {
    private static Singleton instance= null;
    private Singleton(){}
        public static Singleton getInstance(){
            if(instance == null) {
                instance = new Singleton();
                return instance;
            }
            else
                return instance;
        }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
