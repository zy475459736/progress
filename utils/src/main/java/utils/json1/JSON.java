package utils.json1;

import java.lang.annotation.*;

/**
 * Created by zhongyi on 2017/12/11.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JSON {
    /**
     * json1 µÄkeyÖµ
     * @return
     */
    String name();
}
