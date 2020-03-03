package com.etc.test;

class Test{
    public synchronized void  synchronizedMethod(){
        System.out.println("synchronized start");
        try {
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("synchronized end");
    }

    public static synchronized void gernalMethod(){//一般的方法
        System.out.println("gernal method");
    }
}
public class ThreadTest {

    public static void main(String[] args) throws Exception{
        Test t = new Test();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                t.synchronizedMethod();
            }
        };
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(){
            @Override
            public void run() {
                t.gernalMethod();
            }
        };
        t2.start();
    }
}
