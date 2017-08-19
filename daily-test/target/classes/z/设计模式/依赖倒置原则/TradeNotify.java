package z.设计模式.依赖倒置原则;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-16 17:44
 **/
public interface TradeNotify {

    int successNotify(Order order);

    int failNotify(Order order);
}
