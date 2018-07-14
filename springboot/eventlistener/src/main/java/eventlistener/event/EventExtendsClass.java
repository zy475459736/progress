package eventlistener.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by zhongyi on 2017/11/28.
 */
public class EventExtendsClass extends ApplicationEvent {

    private String target = " ,everyone";

    public EventExtendsClass(Object source) {
        super(source);
    }

    public EventExtendsClass(Object source, String target) {
        super(source);
        this.target = target;
    }

    public String getTarget() {
        return target;
    }
}
