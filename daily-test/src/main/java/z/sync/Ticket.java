package z.sync;

import java.util.*;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/1/16.
 */
public class Ticket {

    private static int TOTAL = 1000000;

    public static Set<String> hashSet = new HashSet<>();

    public static Set<String> set = Collections.synchronizedSet(hashSet);

    public  static int getTOTAL() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(TOTAL<=0) {
            return 0;
        }
        TOTAL = TOTAL-1;
        return TOTAL+1;
    }
}
