package z.浮点类型和双精度问题;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/4/1.
 */
public class Detail {

    public static void main(String[] args) {
        float f1 = 16777215f;
        for (int i = 0; i < 10; i++) {
            System.out.println(f1);
            f1++;
        }

        float f = 2.2f;
        double d = (double) f;
        System.out.println(d);
        f = 2.25f;
        d = (double) f;
        System.out.println(d);


        float f11 = 2.2f;
        double d1 = (double) f11;
        System.out.println(f11);
        System.out.println(d1);

    }
}
