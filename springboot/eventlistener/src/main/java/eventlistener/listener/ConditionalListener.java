package eventlistener.listener;


import eventlistener.event.ConditionalEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhongyi on 2017/11/28.
 */
@Component
public class ConditionalListener {

    @EventListener(condition = "#event.isImportant")
    public void onConditionalEvent(ConditionalEvent event) {
        System.out.println("From onConditionalEvent.Begin.");
        System.out.println("Details:"+event.getDetails());
        System.out.println("From onConditionalEvent.End.");
    }

    @EventListener(condition = "!#event.isImportant")
    public void onConditionalEvent2(ConditionalEvent event) {
        System.out.println("From onConditionalEvent2.Begin.");
        System.out.println("Details:"+event.getDetails());
        System.out.println("From onConditionalEvent2.End.");
    }
}
