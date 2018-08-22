import me.personal.progress.simplefactory.IShape;
import me.personal.progress.simplefactory.ShapeFactory;

/**
 * Created by zhongyi on 2018/8/21.
 */
public class test {
    public static void main(String[] args) {
        IShape circle = ShapeFactory.getShape("circle");
        circle.draw();

        IShape rectangle = ShapeFactory.getShape("rect");
        rectangle.draw();

        IShape triangle = ShapeFactory.getShape("triangle");
        triangle.draw();
    }
}
