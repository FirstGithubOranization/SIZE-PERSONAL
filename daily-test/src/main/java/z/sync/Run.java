package z.sync;

import java.util.Calendar;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/1/16.
 */
public class Run implements Runnable {
    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            int no = Ticket.getTOTAL();
            if (no == 0) flag = false;
            else {
//                System.out.println((Thread.currentThread().getName() + "出售：" + no));
                Ticket.set.add(no + ""+Math.random()*100);
            }
        }
        System.out.println("Ticket.set.size() = " + Ticket.set.size());
    }
}
