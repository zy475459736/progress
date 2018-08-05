package me.personal.skills.json1;

import java.lang.annotation.*;

/**
 * Created by zhongyi on 2017/12/11.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JSON {
    /**
     * json1 ��keyֵ
     * @return
     */
    String name();
}
