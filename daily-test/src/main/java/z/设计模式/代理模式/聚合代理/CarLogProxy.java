package z.设计模式.代理模式.聚合代理;

import z.设计模式.代理模式.Moveable;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 17:01
 **/
public class CarLogProxy implements Moveable {

    private Moveable moveable;


    public CarLogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("开始日志");
        moveable.move();
        System.out.println("日志结束");
    }
}
