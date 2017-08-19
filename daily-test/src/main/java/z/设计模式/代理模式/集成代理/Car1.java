package z.设计模式.代理模式.集成代理;

import z.设计模式.代理模式.Car;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 12:48
 **/
public class Car1 extends Car {

    @Override
    public void move() {
        System.out.println("上车完成");
        super.move();
        System.out.println("下车完成");
    }
}
