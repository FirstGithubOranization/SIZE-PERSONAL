package z.设计模式.策略模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-16 14:18
 **/
public class IOSRechargeStrategy implements  IRechargeStrategy {
    @Override
    public float operate(float rechargeMoney) {
        float finalMoney = (float) (rechargeMoney * 0.7);
        System.out.println("IOS充值"+rechargeMoney +"等到"+finalMoney + "元");
        return finalMoney;
    }
}
