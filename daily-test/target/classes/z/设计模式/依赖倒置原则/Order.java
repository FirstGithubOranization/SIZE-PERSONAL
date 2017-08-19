package z.设计模式.依赖倒置原则;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-16 17:37
 **/
public class Order {

    private String orderId;

    private String  goodType;

    private int status;

    private float amount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
