package z.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-05 15:55
 **/
public class Test {

    public static void main(String[] args) {
//        FunctionInterf functionInterf = Person::new;
//        Person person  = functionInterf.getPerson("zhangSan",20);
//        System.out.println(person.getAge());

        Supplier<Person> personSupplier = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("aaa3");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
//        list.forEach(new Consumer<String>() {
//
//            @Override
//            public void accept(String t) {
//                System.out.println("---->"+t);
//
//            }
//        });

        list.stream()
                .sorted(new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        // TODO Auto-generated method stub
                        return o1.compareTo(o2);
                    }
                })
                .filter(new Predicate<String>() {

                    @Override
                    public boolean test(String t) {

                        return t.startsWith("a");
                    }
                })
                .forEach(new Consumer<String>() {

                    @Override
                    public void accept(String t) {
                        System.out.println("---->"+t);

                    }
                });

        Runnable runable=()->{System.out.println("--->");};
        new Thread(()->{System.out.println("--->");}).start();
    }
}
