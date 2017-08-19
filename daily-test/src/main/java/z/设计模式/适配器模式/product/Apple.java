package z.设计模式.适配器模式.product;

import z.设计模式.适配器模式.drivers.IOSWire;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-17 18:58
 **/
public class Apple implements IOSWire {


    @Override
    public String iosTransfer() {
        System.out.println("苹果IPHONE正在用苹果数据先通讯...");
        return null;
    }

    public String dataTransfer(IOSWire iosWire){
        iosWire.iosTransfer();
        return iosTransfer();
    }
}
