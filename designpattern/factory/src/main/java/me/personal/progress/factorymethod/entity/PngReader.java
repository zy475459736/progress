package me.personal.progress.factorymethod.entity;

/**
 * Created by zhongyi on 2018/8/21.
 */
public class PngReader implements IReader {
    @Override
    public void read() {
        System.out.print("read png");
    }
}