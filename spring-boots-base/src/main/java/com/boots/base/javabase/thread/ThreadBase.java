package com.boots.base.javabase.thread;

public class ThreadBase extends Thread{

    public void  run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() + " ------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("ThreadBase.main  Start ");
        ThreadBase th1 = new ThreadBase();
        ThreadBase th2 = new ThreadBase();

        Thread.sleep(20000);
        th1.start();
        th2.start();
    }

}
