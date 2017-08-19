package z.设计模式.适配器模式.product;

import z.设计模式.适配器模式.drivers.IOSWire;
import z.设计模式.适配器模式.drivers.USBWire;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-17 19:58
 **/

public class IOSLine {

    public String lineTransfer(IOSWire iosWire, USBWire usbWire) {
        iosWire.iosTransfer();
        usbWire.usbTransfer();
        System.out.println("ios数据线正常工作...");
        return null;
    }
}




