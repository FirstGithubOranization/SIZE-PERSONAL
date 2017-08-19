package z.设计模式.适配器模式;

import z.设计模式.适配器模式.product.*;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-17 19:50
 **/
public class Test {

    public static void main(String[] args) {
        Computer computer = new Computer();
        IOS2AndroidAdapter adapter = new IOS2AndroidAdapter();
        Apple apple = new Apple();
        MI mi = new MI();
        IOSLine iosLine = new IOSLine();
        iosLine.lineTransfer(apple,computer);
        iosLine.lineTransfer(adapter,computer);

    }
}
