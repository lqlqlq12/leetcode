package Verify;

import java.text.SimpleDateFormat;
import java.util.Date;

public class A {

    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public synchronized static void funcA() throws InterruptedException {
        System.out.println("线程" + Thread.currentThread().getName() + "获得类锁,静态方法funcA");
        System.out.println(sdf.format(new Date()));
        Thread.sleep(5000);
        System.out.println(sdf.format(new Date()));
    }

    public synchronized void funcB() throws InterruptedException {
        System.out.println("线程" + Thread.currentThread().getName() + "获得对象锁(实例锁),实例方法funcB");
        System.out.println(sdf.format(new Date()));
        Thread.sleep(5000);
        System.out.println(sdf.format(new Date()));
    }

    public void funcC() throws InterruptedException {
        synchronized (A.class) {
            System.out.println("线程" + Thread.currentThread().getName() + "获得类锁,func()中的代码块");
            System.out.println(sdf.format(new Date()));
            Thread.sleep(5000);
            System.out.println(sdf.format(new Date()));
        }
    }

    public void funcD() throws InterruptedException {
        synchronized (this) {
            System.out.println("线程" + Thread.currentThread().getName() + "获得对象锁(实例锁),funcD()中的代码块");
            System.out.println(sdf.format(new Date()));
            Thread.sleep(5000);
            System.out.println(sdf.format(new Date()));
        }
    }
}
