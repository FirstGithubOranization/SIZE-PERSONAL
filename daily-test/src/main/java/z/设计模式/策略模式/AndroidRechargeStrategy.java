package z.设计模式.策略模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-16 14:16
 **/
public class AndroidRechargeStrategy implements IRechargeStrategy {

    @Override
    public float operate(float rechargeMoney) {
        float finalMoney = rechargeMoney * 1;
        System.out.println("Android 充值" + rechargeMoney + "得到" + finalMoney + "元");
        return finalMoney;
    }
}
