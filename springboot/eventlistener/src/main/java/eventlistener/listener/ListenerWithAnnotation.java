package eventlistener.listener;


import eventlistener.event.Event;
import eventlistener.event.EventExtendsClass;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Created by zhongyi on 2017/11/28.
 */
@Component
@EnableAsync
public class ListenerWithAnnotation {
    //spring自带event
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("From ListenerWithAnnotation. Event: ContextRefreshedEvent.");
        System.out.println(event.getApplicationContext().toString());
    }

    /*******************************************************************************/

    @EventListener
    @Async
    public void onApplicationEvent1(EventExtendsClass event) throws InterruptedException {
        System.out.println("From onApplicationEvent1.Event: EventExtendsClass.");
        System.out.println("Service logic 1 begins.");
        System.out.println("...........3000ms................");
        Thread.sleep(3000);
        System.out.println("Service logic 1 ends.");
    }

    @EventListener
    @Async
    public void onApplicationEvent2(EventExtendsClass event) throws InterruptedException {
        System.out.println("From onApplicationEvent2.Event: EventExtendsClass.");
        System.out.println("Service logic 2 begins.");
        System.out.println("..........1500ms.................");
        Thread.sleep(1500);
        System.out.println("Service logic 2 ends.");
    }

    @EventListener(classes = EventExtendsClass.class)
    @Async
    public void onApplicationEvent3() throws InterruptedException {
        System.out.println("From onApplicationEvent3.Event: EventExtendsClass.");
        System.out.println("Service logic 3 begins.");
        System.out.println(".........500ms..................");
        Thread.sleep(500);
        System.out.println("Service logic 3 ends.");
    }
    /*******************************************************************************/

    @EventListener
    public void onApplicationEvent4(Event event) {
        System.out.println("From onApplicationEvent4.Event: Event.");
        System.out.println("Service logic 4 begins.");
        System.out.println("...........................");
        System.out.println("Service logic 4 ends.");
        System.out.println();
    }
    /*******************************************************************************/

//    private static int count =0;
//    @EventListener
//    //spring自带event
//    public void RequestListener(RequestHandledEvent event) {
//        System.out.println("***********************************************************  From RequestListener. Event: RequestHandledEvent." );
//        System.out.println(count++ + event.toString());
//    }
}
