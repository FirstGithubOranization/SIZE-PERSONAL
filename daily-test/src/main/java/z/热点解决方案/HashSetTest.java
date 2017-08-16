package z.热点解决方案;

import java.sql.Timestamp;
import java.util.*;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-05-10 14:06
 **/
public class HashSetTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0 ; i < list.size();i++){
            System.out.println(list.get(i));
        }
        list.add(0,4);
        for (int i = 0 ; i < list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
