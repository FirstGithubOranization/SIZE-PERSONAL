package z.sync;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/1/16.
 */
public class Main {

    public static void main(String[] args) {
        Thread t1= new Thread(new Run(),"窗口01");
        Thread t2= new Thread(new Run(),"窗口02");
        Thread t3= new Thread(new Run(),"窗口03");
        Thread t4= new Thread(new Run(),"窗口04");
        Thread t5= new Thread(new Run(),"窗口05");
        Thread t6= new Thread(new Run(),"窗口06");
        Thread t7= new Thread(new Run(),"窗口06");
        Thread t8= new Thread(new Run(),"窗口06");
        Thread t9= new Thread(new Run(),"窗口06");
        Thread t10= new Thread(new Run(),"窗口06");
        Thread t11= new Thread(new Run(),"窗口06");
        Thread t12= new Thread(new Run(),"窗口06");
        Thread t14= new Thread(new Run(),"窗口06");
        Thread t13= new Thread(new Run(),"窗口06");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
//        t7.start();
//        t8.start();
//        t9.start();
//        t10.start();
//        t11.start();
//        t12.start();
//        t13.start();
//        t14.start();
    }
}
