package z.设计模式.适配器模式.product;

import z.设计模式.适配器模式.drivers.USBWire;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-17 19:02
 **/
public class Computer implements USBWire{

    @Override
    public String usbTransfer() {
        System.out.println("电脑正在使用USB通讯...");
        return null;
    }
}
