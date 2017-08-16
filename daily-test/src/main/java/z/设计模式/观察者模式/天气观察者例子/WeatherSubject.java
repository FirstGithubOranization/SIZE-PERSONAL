package z.设计模式.观察者模式.天气观察者例子;

import java.util.ArrayList;
import java.util.List;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-28 17:20
 **/
public class WeatherSubject {

    private List<WeatherObserver> observers = new ArrayList<>();

    public void attach(WeatherObserver observer){
        observers.add(observer);
    }

    public void detatch(WeatherObserver observer){
        observers.remove(observer);
    }

    protected void notifyObserver(){
        for (WeatherObserver o :
                observers) {
            o.update(this);
        }
    }
}
