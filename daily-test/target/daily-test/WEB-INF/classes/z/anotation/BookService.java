package z.anotation;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * Created by [Z]hong[H]e.[Z]h on 2016/12/27.
 */
@Component
public class BookService {

    void insert(BookModel bookModel, String userid) {
        System.out.println("创建新缓存");
    }

    void update(BookModel bookModel) {
        System.out.println("删除缓存");
    }

    @Cacheable(value ="result",key = "#a")
    int query(int a) {
        System.out.println("第一次有执行");
        return a;
    }
}
