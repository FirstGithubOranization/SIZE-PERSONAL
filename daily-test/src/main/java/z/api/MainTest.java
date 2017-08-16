package z.api;

/**
 *
 * Created by ZhongHe.Zh on 2016/12/26.
 */
public class MainTest {

    public static void main(String[] args) {
        int middle = 6;
        for (int i = 0;i<11;i++){
            for (int j = 0;j<middle;j++){
                if(j == 5-i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            for (int j = 0;j<middle;j++){
                if(j == i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0;i<11;i++){
            for (int j = 0;j<middle;j++){
                if(j == i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            for (int j = 0;j<middle;j++){
                if(j == 5-i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}