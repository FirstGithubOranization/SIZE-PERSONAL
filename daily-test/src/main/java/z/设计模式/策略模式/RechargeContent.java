package z.设计模式.策略模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-16 14:22
 **/
public class RechargeContent {

    private IRechargeStrategy rechargeStrategy;

    public RechargeContent(IRechargeStrategy rechargeStrategy) {
        this.rechargeStrategy = rechargeStrategy;
    }

    public float recharge(float money) {
        return rechargeStrategy.operate(money);
    }
}
