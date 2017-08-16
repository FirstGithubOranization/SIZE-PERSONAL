package z.线程终止;

import java.util.Calendar;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/4/22.
 */
public class Test {

    public static int count = 0;

    public String getTime() {
        count++;
        return count + "";
    }

}
