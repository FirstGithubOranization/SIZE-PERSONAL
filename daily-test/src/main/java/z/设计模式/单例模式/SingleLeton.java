package z.设计模式.单例模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-17 15:21
 **/

public class SingleLeton {


    private SingleLeton() {
    }

    public static SingleLeton getInstance() {
        return InstalSingleLeton.instance;
    }

    private static class InstalSingleLeton

    {
        private static SingleLeton instance = new SingleLeton();
    }
}

//典型单例：
//public class SingleLeton{
//    private static SingleLeton instance = null;
//
//    //私有化构造函数，避免实例化
//    private SingleLeton(){
//    }
//
//    private static SingleLeton getInstance(){
//        if(instance == null){
//            return new SingleLeton();
//        }
//    }
//
//}
//
//当初步考虑并发时：
//public class SingleLeton{
//
//    private static SingleLeton = null;
//
//    private SingleLeton(){
//    }
//
//    public static sychronized SingleLeton getInstance(){
//        if(instance==null){
//            instance = new SingleLeton();
//        }
//    }
//}
//单上上述单例存在性能问题，因为线程会不停的阻塞在getInstance方法，而实际上初始化只需要一次
//
//        比较完美的写法，是将初始化和获取单例对象分开
//public class SingleLeton{
//
//    private static SingleLeton  instance = null;
//
//    private SingleLeton(){
//    }
//
//    priavte staic sychronized intInstance(){
//        if(instance == null){
//            instance = new SingleLeton();
//        }
//    }
//
//    public static SingleLeton getInstance(){
//        if(instance == null){
//            initInstance();
//        }
//        return instance;
//    }
//}
//但是上述的单例其实也会出问题:
//        因为JVM创建对象和赋值操作不是同步的，也就是说，instance = new SingleLeton()并是异步的，而且先后顺序是不定的，这样的线程执行完instance = new SingleLeton后，释放锁，下一个线程获得锁后判断instance是否为空，如果此时JVM只是新分配了内存空间，将地址赋值给instance，还没有初始化SingleLeton的实例，那么下一个线程进入时，instance指向的内存空间依旧是空，那么就会出问题
//
//
//        还有一种单例的实现方式：
//
//public class SingleLeton{
//
//    private static SingleLeton  instance = null;
//
//    private SingleLeton(){
//    }
//
//    public static SingleLeton getInstance(){
//        return instance;
//    }
//
//    private static InstalSingleLeton{
//        instance = new SingleLetion()
//    }
//}
//
//其实这样也会存在问题，如果在内部分初始化的时候出错，那么会导致用户拿不到instance的实例，
//
//        所以说，不存在最完美的单例 = = 我好方
