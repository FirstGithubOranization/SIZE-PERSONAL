package z.线程终止;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/4/22.
 */
public class TimeRun implements Runnable {

    private Test test;

    public TimeRun(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        String time = test.getTime();
        if(Test.count%2 == 0){
            System.out.println(time);
        }else{
            Thread.currentThread().interrupt();
            System.out.println("####");
        }

    }
}
