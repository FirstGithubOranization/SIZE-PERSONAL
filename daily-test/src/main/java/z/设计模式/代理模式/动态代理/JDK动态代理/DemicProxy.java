package z.设计模式.代理模式.动态代理.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-18 17:13
 **/
public class DemicProxy implements InvocationHandler {

    private Object object;

    public DemicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始...");
        method.invoke(object);
        System.out.println("动态代理结束...");
        return null;
    }

    /**
     * 返回动态代理对象 方法
     * @return 动态代理对象
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

}
