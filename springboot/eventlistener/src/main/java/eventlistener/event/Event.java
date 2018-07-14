package eventlistener.event;

/**
 * Created by zhongyi on 2017/11/28.
 */
public class Event {

    private Object source;

    private String target = " ,everyone";

    public Event(Object source) {
        this.source = source;
    }

    public Event(Object source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getTarget() {
        return target;
    }
}
