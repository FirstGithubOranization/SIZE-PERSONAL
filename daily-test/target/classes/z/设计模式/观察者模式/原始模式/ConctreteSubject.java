package z.设计模式.观察者模式.原始模式;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-28 17:23
 **/
public class ConctreteSubject extends Subject {

    private String subjectStatus;

    public String getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(String subjectStatus) {
        this.notifyObserver();
        this.subjectStatus = subjectStatus;
    }
}
