package me.personal.progress.simplefactory;

/**
 * Created by zhongyi on 2018/8/21.
 */
public class CircleShape implements IShape {

    public CircleShape() {
        System.out.println(  "CircleShape: created");
    }

    @Override
    public void draw() {
        System.out.println(  "draw: CircleShape");
    }

}