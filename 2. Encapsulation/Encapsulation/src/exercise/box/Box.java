package exercise.box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        checkIfNegative(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        checkIfNegative(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkIfNegative(height, "Height");
        this.height = height;
    }

    private void checkIfNegative(double number, String text) {
        if (number <= 0) {
            throw new IllegalArgumentException(text + "  cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        // 2lw + 2lh + 2wh
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        // 2lh + 2wh
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        // lwh
        return length * width * height;
    }
}
