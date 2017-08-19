package z.设计模式.桥接模式.original;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 12:03
 **/
public class SourceSub2 implements  Sourceable {
    @Override
    public void method() {
        System.out.println("method from Sub2..");
    }
}
