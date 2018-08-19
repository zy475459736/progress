package me.personal.progress.proxy_static;

import me.personal.progress.AbstractObject;

/**
 * Created by zhongyi on 2018/8/19.
 */
public class ProxyObject extends AbstractObject {
    RealObject realObject = new RealObject();

    @Override
    public void operation() {
        //在调用目标对象之前，完成一些操作
        System.out.println("Before Do Something");
        realObject.operation();
        //在调用目标对象之后，完成一些操作
        System.out.println("After Do Something");
    }
}

