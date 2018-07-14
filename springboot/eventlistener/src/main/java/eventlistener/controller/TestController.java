package eventlistener.controller;


import eventlistener.event.ConditionalEvent;
import eventlistener.event.Event;
import eventlistener.event.EventExtendsClass;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhongyi on 2017/11/28.
 */
@Controller
@RequestMapping("/demo")
public class TestController implements ApplicationEventPublisherAware{

    /*广播器实现方式一
    (带接口ApplicationEventPublisherAware或者ApplicationContextAware)*/
    ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /*广播器实现方式二(无需接口)*/
    /* @Autowired
    ApplicationEventPublisher applicationEventPublisher;*/

    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String everyone(@RequestParam(value = "keyword", defaultValue = " everyone") String keyword) {
        if(keyword.equals("world")){
            applicationEventPublisher.publishEvent(new EventExtendsClass(this,"world"));
            return "hello world";
        }
        applicationEventPublisher.publishEvent(new Event(this,"world"));
        return "hello everyone";
    }

    @ResponseBody
    @RequestMapping(value = "/condition")
    public String condition(@RequestParam(value = "isImportant", defaultValue = "false")
                                        String isImportant,
                            @RequestParam(value = "details"    , defaultValue = "Here is the detail.")
                                    String details     ) {
        if( "true".equals(isImportant.trim().toLowerCase()) )
            applicationEventPublisher.
                    publishEvent(new ConditionalEvent(details,true));
        else
            applicationEventPublisher.
                    publishEvent(new ConditionalEvent(details,false));
        return "hello condition";
    }


}