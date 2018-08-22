package me.personal.progress.factorymethod.entity;

/**
 * Created by zhongyi on 2018/8/21.
 */
public class GifReader implements IReader {
    @Override
    public void read() {
        System.out.print("read gif");
    }
}