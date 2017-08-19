package z.设计模式.代理模式.动态代理.CGLIB动态代理;

import z.设计模式.代理模式.Car;
import z.设计模式.代理模式.Moveable;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-19 17:42
 **/
public class Test {

    public static void main(String[] args) {
        CGLIBProxy cglibProxy = new CGLIBProxy();
        Moveable moveable=(Moveable) cglibProxy.getProxy(Car.class);
        moveable.move();
    }
}
