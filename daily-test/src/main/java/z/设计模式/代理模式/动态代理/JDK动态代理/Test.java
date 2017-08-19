package z.设计模式.代理模式.动态代理.JDK动态代理;

import z.设计模式.代理模式.Car;
import z.设计模式.代理模式.Moveable;

import java.lang.reflect.Proxy;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 17:19
 **/
public class Test {

    public static void main(String[] args) {
        Car car = new Car();
        DemicProxy proxy = new DemicProxy(car);

//        Moveable moveable = (Moveable) Proxy.newProxyInstance(Car.class.getClassLoader(), car.getClass().getInterfaces(), proxy);
        Moveable moveable = (Moveable) proxy.getProxy();
        moveable.move();
    }

}
