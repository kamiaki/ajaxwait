package com.aki.ajaxwait;

public class TestMain {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("来来");
//                testMain.notify();
            }
        });
        thread.start();
        testMain.testwait();
        while(true)
        {
            System.out.println("Main方法在运行");
        }

    }

    public void testwait(){
        System.out.println("开始等地啊");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待结束");

    }
}
