package z.设计模式.策略模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-16 14:15
 **/
public interface IRechargeStrategy {

    /**
     *
     * @param rechargeMoney
     * @return
     */
    float operate(float rechargeMoney);
}
