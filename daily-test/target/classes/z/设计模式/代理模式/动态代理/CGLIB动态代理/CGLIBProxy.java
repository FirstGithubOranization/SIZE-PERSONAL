package z.设计模式.代理模式.动态代理.CGLIB动态代理;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-19 17:06
 **/
public class CGLIBProxy implements MethodInterceptor {


    /**
     * Enhancer 其实是继承了抽象类AbstractClassGenerator 超类是ClassGenerator
     * <p>
     * 这里的作用是用于创建被代理类的子类
     */
    Enhancer enhancer = new Enhancer();

    /**
     * 创建被代理对象的代理子类
     *
     * @param cls 被代理对象的class对象
     *
     * @return 子类对象
     */
    public Object getProxy(Class cls) {
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理方法执行前...");
        /*这里必须调用的是invokeSuper 否则会报错*/
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("cglib动态代理方法执行后...");
        return result;
    }
}
