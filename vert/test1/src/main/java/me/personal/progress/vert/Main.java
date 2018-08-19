package me.personal.progress.vert;

import io.vertx.core.Vertx;

/**
 * Created by zhongyi on 2018/8/15.
 */
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MyFirstVehicle.class.getName());
    }
}
