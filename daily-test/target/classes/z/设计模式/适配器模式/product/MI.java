package z.设计模式.适配器模式.product;

import z.设计模式.适配器模式.drivers.AndroidWire;
import z.设计模式.适配器模式.drivers.USBWire;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-17 19:03
 **/
public class MI implements AndroidWire {


    @Override
    public String androidTransfer() {
        System.out.println("小米MI正在用安卓数据先通信...");
        return null;
    }
}
