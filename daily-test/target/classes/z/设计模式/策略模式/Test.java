package z.设计模式.策略模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-16 14:23
 **/
public class Test {

    public static void main(String[] args) {
        RechargeContent rechargeContent = new RechargeContent(new IOSRechargeStrategy());
        rechargeContent.recharge(100f);
    }
}
