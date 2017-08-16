package z.线程终止;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/4/22.
 */
public class Main {


    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0 ; i< 200;i++)
        {
            TimeRun run = new TimeRun(test);
            Thread t = new Thread(run);
            t.start();
        }

    }

}
