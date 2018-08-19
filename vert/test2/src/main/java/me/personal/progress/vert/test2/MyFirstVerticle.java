package me.personal.progress.vert.test2;

import io.vertx.core.AbstractVerticle;

/**
 * Created by zhongyi on 2018/8/16.
 */
public class MyFirstVerticle extends AbstractVerticle {
    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("Content-type", "text/plain")
                    .end("Hello world! from 8081");
        }).listen(8081);
    }
}
