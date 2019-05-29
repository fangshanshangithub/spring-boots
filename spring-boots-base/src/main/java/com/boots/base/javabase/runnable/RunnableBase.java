package com.boots.base.javabase.runnable;

public class RunnableBase {

    public static void main(String[] args) {
        new Thread(new RunnablesThread()).start();
        new Thread(new RunnablesThread()).start();
    }


    static class RunnablesThread implements Runnable {
        @Override
        public void run() {

            int i = 1;
            while(i > 0) {
                if(i == 5) {
                    System.out.println(Thread.currentThread().getName() + ": i==5; 开始sleep");
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println(Thread.currentThread().getName() + "-- 执行：" + i);
            }
        }
    }

}
