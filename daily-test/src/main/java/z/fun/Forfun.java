package z.fun;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/4/19.
 */
public class Forfun {

    //    public static void main(String[] args) {
//        int a,b,c;
//        for (a = 0 ; a < 10 ;a++){
//            for (b = 0 ; b < 10 ; b++)
//                for (c = 0 ; c < 10 ; c++ ){
//                    int result = 100 * a  + 10 *b + c + 100 * c + 10 * b +a;
//                    if(result == 1333){
//                        System.out.print(a+","+b+","+c);
//                        System.out.println("--------");
//                    }
//
//                }
//        }
//    }
    public static void main(String[] args) {
        int count = 0;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= 99; i++) {
            arr.add(1);
        }
        for (int h = 1; h<101;h++) {
            for (int j = 2; j <= 100; j++) {
                if (h% j == 0) {
                    arr.set(h-1, arr.get(h-1) * -1);
                }
            }
        }
        for (int k = 1; k <= 100; k++) {
            if (arr.get(k - 1) > 0) {
                count++;
            }
        }
        System.out.println(count);
    }


}
