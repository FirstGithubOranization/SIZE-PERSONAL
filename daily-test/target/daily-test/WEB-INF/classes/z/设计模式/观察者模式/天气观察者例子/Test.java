package z.设计模式.观察者模式.天气观察者例子;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-28 18:07
 **/
public class Test {
    public static void main(String[] args)
    {
        /*1.创建目标对象*/
        WeatherConctreteSubject weatherConctreteSubject = new WeatherConctreteSubject();

        /*2.创建观察者*/
        WeatherConcreteObserver observerBoy = new WeatherConcreteObserver();
        observerBoy.setName("Tom");
        observerBoy.setContent("打球");

        WeatherConcreteObserver observerGirl = new WeatherConcreteObserver();
        observerGirl.setName("June");
        observerGirl.setContent("shopping");
        /*3.注册观测者*/
        weatherConctreteSubject.attach(observerBoy);
        weatherConctreteSubject.attach(observerGirl);

        /*4.状态变更*/
        weatherConctreteSubject.setSubjectStatus("天晴天");
    }
}
