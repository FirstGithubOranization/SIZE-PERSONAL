package z.设计模式.代理模式.聚合代理;

import z.设计模式.代理模式.Moveable;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 16:55
 **/
public class CarTimeProxy implements Moveable {

    private Moveable moveable;

    public CarTimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("计时开始");
        moveable.move();
        System.out.println("计时结束");
    }
}
