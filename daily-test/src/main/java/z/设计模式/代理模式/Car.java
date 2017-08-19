package z.设计模式.代理模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 12:46
 **/
public class Car implements  Moveable {
    @Override
    public void move() {
        long startTiime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        try {
            System.out.println("汽车行驶中...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 用时"+(endTime-startTiime)+"毫秒");
    }
}
