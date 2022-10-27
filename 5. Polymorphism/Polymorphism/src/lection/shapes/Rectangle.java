package lection.shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);

        super.setPerimeter(this.calculatePerimeter());
        super.setArea(this.calculateArea());
    }

    public Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * this.height + 2 * this.width;
    }

    @Override
    public double calculateArea() {
        return this.height * this.width;
    }
}
