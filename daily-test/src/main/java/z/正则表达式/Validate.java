package z.正则表达式;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-05-15 17:33
 **/
public class Validate {


    public static void main(String[] args) {
        String pwd="0123456a78";
        boolean b =Pattern.matches("[a-zA-Z](?=.*?[0-9].*?)[a-zA-Z0-9]+|[0-9](?=.*?[a-zA-Z].*?)[a-zA-Z0-9]+", pwd);
        if(b){
            System.out.println("输入正确");
        }else{
            System.out.println("请输入混合密码");
        }
    }
}
