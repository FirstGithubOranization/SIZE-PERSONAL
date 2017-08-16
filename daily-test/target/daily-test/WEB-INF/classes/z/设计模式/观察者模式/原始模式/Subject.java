package z.设计模式.观察者模式.原始模式;

import java.util.ArrayList;
import java.util.List;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-28 17:20
 **/
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detatch(Observer observer){
        observers.remove(observer);
    }

    protected void notifyObserver(){
        for (Observer o :
                observers) {
            o.update(this);
        }
    }
}
