package z.设计模式.观察者模式.天气观察者例子;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-28 17:24
 **/
public class WeatherConcreteObserver implements WeatherObserver {

    private String observerStatus;

    private String name;

    private String content;

    public String getObserverStatus() {
        return observerStatus;
    }

    public void setObserverStatus(String observerStatus) {
        this.observerStatus = observerStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void update(WeatherSubject subject) {
        observerStatus = ((WeatherConctreteSubject)subject).getSubjectStatus();
        System.out.println(name+",明天天气"+observerStatus +"，适合外出"+content);
    }
}
