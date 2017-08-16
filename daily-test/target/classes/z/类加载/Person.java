package z.类加载;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-07-07 13:44
 **/
public class Person {

    private String name ;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void  ear(String foodName){
        System.out.println("i am eating "+foodName);
    }
}
