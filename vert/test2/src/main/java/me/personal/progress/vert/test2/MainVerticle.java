package me.personal.progress.vert.test2;

import io.vertx.core.AbstractVerticle;

/**
 * Created by zhongyi on 2018/8/16.
 */
public class MainVerticle extends AbstractVerticle{
    @Override
    public void start() {
        vertx.deployVerticle(MyFirstVerticle.class.getName());
    }
}
