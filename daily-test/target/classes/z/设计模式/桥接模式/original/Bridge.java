package z.设计模式.桥接模式.original;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 12:04
 **/
public  abstract class Bridge {

    private Sourceable source;

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }

    public void method(){
        source.method();
    }

}
