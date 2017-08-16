package z.测试JAVA中的引用问题;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/4/19.
 */
public class Main {

    public static void main(String[] args) {
        Stu stu = new Stu();
        stu.setAge(1);
        stu.setName("Tom");
        System.out.println(stu.toString());
        System.out.println(stu.hashCode());
        Main main = new Main();
        main.setName(stu);
        System.out.println(stu.toString());
    }

    public  void setName(Stu stu){
        System.out.println(stu.hashCode());
        stu.setName("Jeans");
        Stu stu1 = stu;
        System.out.println(stu1.hashCode());
        System.out.println(stu1.toString());

    }

}

class Stu{
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
