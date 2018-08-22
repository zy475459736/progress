package me.personal.progress.simplefactory;

/**
 * Created by zhongyi on 2018/8/21.
 */
public class ShapeFactory {
    public static final String TAG = "ShapeFactory";
    public static IShape getShape(String type) {
        IShape shape = null;
        if (type.equalsIgnoreCase("circle")) {
            shape = new CircleShape();
        } else if (type.equalsIgnoreCase("rect")) {
            shape = new RectShape();
        } else if (type.equalsIgnoreCase("triangle")) {
            shape = new TriangleShape();
        }
        return shape;
    }
}