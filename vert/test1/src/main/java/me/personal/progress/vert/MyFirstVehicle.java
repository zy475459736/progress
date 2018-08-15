package me.personal.progress.vert;

import io.vertx.core.AbstractVerticle;

/**
 * Created by zhongyi on 2018/8/15.
 */
public class MyFirstVehicle extends AbstractVerticle{
    @Override
    public void start(){
        vertx.createHttpServer().requestHandler(req->{
           req.response()
                   .putHeader("Content-type","text/plain")
                   .end("Hello world!");
        }).listen(8080);
    }
}
