package z.设计模式.适配器模式.product;


import z.设计模式.适配器模式.drivers.AndroidWire;
import z.设计模式.适配器模式.drivers.IOSWire;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-17 20:35
 **/
public class IOS2AndroidAdapter  implements AndroidWire ,IOSWire{

    @Override
    public String androidTransfer() {
        System.out.println("适配器正在使用android接口通讯...");
        return null;
    }

    @Override
    public String iosTransfer() {
        System.out.println("适配器正在使用IOS接口通讯...");
        return null;
    }
}
