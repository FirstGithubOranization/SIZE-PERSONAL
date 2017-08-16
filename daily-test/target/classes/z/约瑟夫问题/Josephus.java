package z.约瑟夫问题;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/3/2.
 */
public class Josephus {

    public static void main(String[] args) {
        int limit = 3;
        int length = 100;
        int index = 0;
        int time = 0;
        int count = 0;
        int[] arr =new int[101];
        //初始化
        for (int i = 0; i < 100; i++) {
            arr[i] = 0;
        }
        do {
            index++;
            if (index>=length) index = 0;
            if (arr[index]==0) time++;
            if(time==limit){
                time=0;
                arr[index] = 1;
                System.out.println("编号"+index+"被淘汰");
                count++;
            }
        } while (count!=length);
        System.out.println("一共被淘汰"+count+"人");

    }
}
