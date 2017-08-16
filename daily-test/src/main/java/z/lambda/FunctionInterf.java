package z.lambda;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-05 15:25
 **/
@FunctionalInterface
public interface FunctionInterf {


    static void staticInfo() {

    }

    default String getZodiacSign(int age) {
        return "Mouse";
    }

    Person getPerson(String name, int age);

}

