package me.personal.progress.simplefactory;

/**
 * Created by zhongyi on 2018/8/21.
 */
public class TriangleShape implements IShape {

    public TriangleShape() {
        System.out.println(  "TriangleShape: created");
    }

    @Override
    public void draw() {
        System.out.println(  "draw: TriangleShape");
    }
}
