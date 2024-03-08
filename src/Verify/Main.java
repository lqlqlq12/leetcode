package Verify;

public class Main {

    //线程x和y竞争同一个对象锁
    public static void test_1() {
        A a1 = new A();
        Thread x = new Thread() {
            @Override
            public void run() {
                try {
                    a1.funcB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread y = new Thread() {
            @Override
            public void run() {
                try {
                    a1.funcB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        y.setName("y");
        x.setName("x");
        x.start();
        y.start();
    }

    //线程x和y竞争两个不同的对象锁
    public static void test_2() {
        A a1 = new A();
        A a2 = new A();
        Thread x = new Thread() {
            @Override
            public void run() {
                try {
                    a1.funcB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread y = new Thread() {
            @Override
            public void run() {
                try {
                    a2.funcB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        y.setName("y");
        x.setName("x");
        x.start();
        y.start();
    }

    //线程x和y竞争同一个类锁
    public static void test_3() {
        Thread x = new Thread() {
            @Override
            public void run() {
                try {
                    A.funcA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread y = new Thread() {
            @Override
            public void run() {
                try {
                    A.funcA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        y.setName("y");
        x.setName("x");
        x.start();
        y.start();
    }

    //线程x和y竞争同一个类锁
    public static void test_4() {
        A a1=new A();
        A a2=new A();
        Thread x = new Thread() {
            @Override
            public void run() {
                try {
                    a1.funcC();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread y = new Thread() {
            @Override
            public void run() {
                try {
                    a2.funcC();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        y.setName("y");
        x.setName("x");
        x.start();
        y.start();
    }

    //线程x和y竞争同一个对象锁
    public static void test_5() {
        A a1 = new A();
        Thread x = new Thread() {
            @Override
            public void run() {
                try {
                    a1.funcD();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread y = new Thread() {
            @Override
            public void run() {
                try {
                    a1.funcD();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        y.setName("y");
        x.setName("x");
        x.start();
        y.start();
    }

    public static void test_6(){
        A a1=new A();
        Thread x=new Thread(){
            @Override
            public void run() {
                try {
                    A.funcA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread y=new Thread(){
            @Override
            public void run() {
                try {
                    a1.funcB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        x.setName("x");
        y.setName("Y");
        x.start();
        y.start();
    }


    public static void test_7(){
        A a1=new A();
        A a2=a1;
        Thread x=new Thread(){
            @Override
            public void run() {
                try {
                    a1.funcB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread y=new Thread(){
            @Override
            public void run() {
                try {
                    a2.funcB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        x.setName("x");
        y.setName("y");
        x.start();
        y.start();
    }

    public static void main(String[] args) {
        test_7();
    }
}
