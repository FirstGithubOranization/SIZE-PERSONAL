package z.anotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * Created by ZhongHe.Zh on 2016/12/27.
 */
public class Test {
    public static void main(String[] args) {
        String[] locations = {"classpath:web-context.xml"};
        ApplicationContext ctx = new FileSystemXmlApplicationContext(locations);
        BookService bookService=(BookService)ctx.getBean("bookService");
        bookService.query(1);
        bookService.query(1);
        bookService.query(1);
        bookService.query(1);
    }
}
