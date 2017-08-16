package z.指数分布;

import java.util.Scanner;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/2/13.
 */
public class Zhishu {

    public static void main(String[] args) {
        double x, z;
        double lamda;

        System.out.println("请输入lamda的值：");
        Scanner scanner = new Scanner(System.in);
        lamda = scanner.nextDouble();

        for (int i = 0; i < 10; i++) {
            z = Math.random();
            x = -(1 / lamda) * Math.log(z);
            System.out.println(x);
        }
    }
}
