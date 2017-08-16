package z.类加载;

import java.util.Arrays;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-07-07 13:46
 **/
public class Test {
    
    public static void main(String[] args) {
        String a = "中国";
        System.out.println(a);
        byte[]  aBytes=a.getBytes();
        System.out.println(Arrays.toString(aBytes));
    }
}
