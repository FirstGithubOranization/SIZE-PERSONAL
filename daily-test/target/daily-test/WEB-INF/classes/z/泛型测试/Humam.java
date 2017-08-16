package z.泛型测试;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/4/21.
 */
public class Humam extends Animal<Humam>{

    private String name;

    private String mind;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMind() {
        return mind;
    }

    public void setMind(String mind) {
        this.mind = mind;
    }
}
