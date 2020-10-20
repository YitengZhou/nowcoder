class MyThread implements Runnable{
    Object o1 = new Object();
    Object o2 = new Object();
    boolean sign =true;
    public MyThread(boolean sign){
        this.sign = sign;
    }
    @Override
    public void run() {
        if (sign){
            sign = false;
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("now"+Thread.currentThread().getName());
                synchronized (o2){
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("now"+Thread.currentThread().getName());
                }
            }
        if (!sign)
            sign = true;
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("now"+Thread.currentThread().getName());
                synchronized (o1){
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("now"+Thread.currentThread().getName());
                }
            }
        }


    }
}

public class DeathLock {


    public static void run(){
        MyThread myThread = new MyThread(true);
        new Thread(myThread,"1").start();
        new Thread(myThread,"2").start();
    }

    public static void main(String[] args) {
        run();
    }

}

