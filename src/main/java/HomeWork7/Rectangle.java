package homeWork7;

public class Rectangle {
    public final double width;
    public final double height;

    // Constructor with 2 params
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Constructor with default height
    public Rectangle(double width) {
        this.width = width;
        this.height = 3;
    }

    // Constructor with default params
    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    // Calculating the area of a rectangle
    public double calculateArea() {
        return width * height;
    }

    // Calculating the perimeter of a rectangle
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
