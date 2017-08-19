package z.设计模式.代理模式.聚合代理;

import z.设计模式.代理模式.Car;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 14:21
 **/
public class Test {

    public static void main(String[] args) {
        Car car = new Car();
        CarLogProxy carLogProxy = new CarLogProxy(car);
        CarTimeProxy carTimeProxy = new CarTimeProxy(carLogProxy);
        carTimeProxy.move();
    }
}
