package homeWork7;

import org.testng.annotations.Test;

public class RectangleTest {
    @Test
    public void calculateCustomRectangle() {
        Rectangle rectangle = new Rectangle(5.7, 4.2);
        double actualArea = rectangle.calculateArea();
        double actualPerimeter = rectangle.calculatePerimeter();
        System.out.println("Custom rectangle area is " + actualArea + "\nand perimeter is " + actualPerimeter);

    }

    @Test
    public void calculateDefaultWidthRectangle() {
        Rectangle rectangle = new Rectangle(2);
        double actualArea = rectangle.calculateArea();
        double actualPerimeter = rectangle.calculatePerimeter();
        System.out.println("Default width rectangle area is " + actualArea + "\nand perimeter is " + actualPerimeter);

    }

    @Test
    public void calculateDefaultRectangle() {
        Rectangle rectangle = new Rectangle();
        double actualArea = rectangle.calculateArea();
        double actualPerimeter = rectangle.calculatePerimeter();
        System.out.println("Default rectangle area is " + actualArea + "\nand perimeter is " + actualPerimeter);

    }
}
