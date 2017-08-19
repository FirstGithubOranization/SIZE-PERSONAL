package z.设计模式.桥接模式.original;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 12:05
 **/
public class MyBridge extends Bridge {

    public void method(){
        getSource().method();
    }
}
