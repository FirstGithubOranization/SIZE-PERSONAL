package z.泛型详述;

import org.springframework.http.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/4/14.
 */
public class GenericMethod {
    public static <T> T getMiddle(HttpServletRequest request, HttpRequest requestq){

        Cookie[] cookie =request.getCookies();
        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }


}







