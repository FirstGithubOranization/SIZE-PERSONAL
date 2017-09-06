package z.设计模式.桥接模式.original;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 12:06
 **/
public class     Test {


    public static void main(String[] args) {

        Bridge bridge = new MyBridge();

        Sourceable sourceable = new SourceSub1();

        bridge.setSource(sourceable);

        sourceable.method();


        SourceSub2 sourceSub2 = new SourceSub2();

        bridge.setSource(sourceSub2);

        bridge.method();

    }


}
