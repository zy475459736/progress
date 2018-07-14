package eventlistener.event;

/**
 * Created by zhongyi on 2017/11/28.
 */
public class ConditionalEvent {
    private Object source;
    private String details;
    public boolean isImportant;

    public ConditionalEvent(String details) {
        this(details, false);
    }
    public ConditionalEvent(String details, boolean isImportant) {
        this.source = this ;
        this.details = details;
        this.isImportant = isImportant;
    }

    public String getDetails() {
        return details;
    }
    public boolean isImportant() {
        return isImportant;
    }
}
