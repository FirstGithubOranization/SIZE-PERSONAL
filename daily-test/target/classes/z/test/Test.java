package z.test;

import java.util.ArrayList;
import java.util.List;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-07-19 15:44
 **/
public class Test<T> {

    public static void main(String[] args) {
        Dog  d = new Dog();
        d.setName("小白");
//        new Test<>().valid(d);
        List<Dog> list = new ArrayList<>();
        list.add(d);
    }

    private T valid(T t){
        System.out.println(Dog.class.cast(t).name);
        return null;
    }


}
