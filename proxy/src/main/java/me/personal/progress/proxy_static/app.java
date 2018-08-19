package me.personal.progress.proxy_static;

import me.personal.progress.AbstractObject;

/**
 * Created by zhongyi on 2018/8/19.
 */
public class app {
    public static void main(String[] args) {
        AbstractObject abstractObject = new ProxyObject();
        abstractObject.operation();
    }

}
