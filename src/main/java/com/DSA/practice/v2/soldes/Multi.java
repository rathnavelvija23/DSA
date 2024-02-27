package com.DSA.practice.v2.soldes;

class Multi extends Thread{
    public void run(){
        System.out.println("thread is running...");
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String args[]){
        Multi t1=new Multi();
      //  t1.start();
        t1.run();
    }
}
