package z.设计模式.观察者模式.原始模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-28 17:24
 **/
public class ConcreteObserver implements Observer {

    private String observerStatus;

    @Override
    public void update(Subject subject) {
        observerStatus = ((ConctreteSubject)subject).getSubjectStatus();
    }
}
