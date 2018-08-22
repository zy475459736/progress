package me.personal.progress.simplefactory;

/**
 * Created by zhongyi on 2018/8/21.
 */
public class RectShape implements IShape {

    public RectShape() {
        System.out.println(  "RectShape: created");
    }

    @Override
    public void draw() {
        System.out.println(  "draw: RectShape");
    }

}