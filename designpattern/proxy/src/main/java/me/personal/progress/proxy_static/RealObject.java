package me.personal.progress.proxy_static;

import me.personal.progress.AbstractObject;

/**
 * Created by zhongyi on 2018/8/19.
 */
public class RealObject extends AbstractObject {
    @Override
    public void operation() {
        System.out.println("Do Something!");
    }
}
